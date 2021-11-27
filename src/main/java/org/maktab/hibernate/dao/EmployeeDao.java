package org.maktab.hibernate.dao;

import org.maktab.hibernate.entity.Employee;
import org.maktab.hibernate.exception.DataNotFoundException;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class EmployeeDao extends AbstractJpaDao<Employee, Integer> {

    @Override
    public void update(Integer id, Employee newEntity) {

    }

    public Employee login(String userName, String password) throws DataNotFoundException {
        TypedQuery<Employee> typedQuery = getEntityManager().createQuery(
                        "select e from Employee e where userName=:userName and password=:password",
                        Employee.class
                ).setParameter("userName", userName)
                .setParameter("password", password);

        Employee employee;
        try {
            employee = typedQuery.getSingleResult();
        } catch (NoResultException e) {
            throw new DataNotFoundException("User Not Found!");
        }
        return employee;
    }

    @Override
    public Class<Employee> getEntityClass() {
        return Employee.class;
    }
}
