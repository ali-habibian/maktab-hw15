package org.maktab.hibernate;

import org.maktab.hibernate.config.DbConfig;
import org.maktab.hibernate.entity.Account;
import org.maktab.hibernate.entity.Customer;
import org.maktab.hibernate.entity.Employee;
import org.maktab.hibernate.entity.EmployeeRole;
import org.maktab.hibernate.entity.transaction.Deposit;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("BankManagement");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

//        Employee employee = new Employee();
//        employee.setFullName("Ali Habibian");
//        employee.setPassword("4521097");
//        employee.setUserName("ali");
//        employee.setRole(EmployeeRole.TELLER);
//        entityManager.persist(employee);

//        Employee employee1 = entityManager.find(Employee.class, 1);
//        EmployeeRole role = employee1.getRole();
//        System.out.println(role);

        Account account = new Account();
        account.setAccountNumber(1222554555666L);
        account.setBalance(500.0);
        entityManager.persist(account);


        // Problem with get all transactions
//        Deposit deposit = new Deposit();
//        deposit.setAmount(500.0);
//        deposit.setSourceAccount(account);
//        deposit.execute();
//        entityManager.persist(deposit);
//        account = deposit.getSourceAccount();
//        entityManager.merge(account);

        entityManager.getTransaction().commit();
    }
}
