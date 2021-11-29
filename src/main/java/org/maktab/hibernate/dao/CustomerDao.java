package org.maktab.hibernate.dao;

import org.maktab.hibernate.entity.Customer;
import org.maktab.hibernate.entity.Employee;
import org.maktab.hibernate.exception.DataNotFoundException;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class CustomerDao extends AbstractJpaDao<Customer, Integer> {

    @Override
    public void update(Integer id, Customer newEntity) {
        Customer customer = loadById(id);
        customer.setUserName(newEntity.getUserName());
        customer.setPassword(newEntity.getPassword());
        getEntityManager().merge(customer);
    }

    public Customer login(String userName, String password) throws DataNotFoundException {
        TypedQuery<Customer> typedQuery = getEntityManager().createQuery(
                        "select e from Customer e where e.userName=:userName and e.password=:password",
                        Customer.class
                ).setParameter("userName", userName)
                .setParameter("password", password);

        Customer customer;
        try {
            customer = typedQuery.getSingleResult();
        } catch (NoResultException e) {
            throw new DataNotFoundException("User Not Found!");
        }
        return customer;
    }

    @Override
    public Class<Customer> getEntityClass() {
        return Customer.class;
    }
}
