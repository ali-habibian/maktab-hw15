package org.maktab.hibernate.dao;

import org.maktab.hibernate.entity.Customer;

public class CustomerDao extends AbstractJpaDao<Customer, Integer> {

    @Override
    public void update(Integer id, Customer newEntity) {
        Customer customer = loadById(id);
        customer.setUserName(newEntity.getUserName());
        customer.setPassword(newEntity.getPassword());
        getEntityManager().merge(customer);
    }

    @Override
    public Class<Customer> getEntityClass() {
        return Customer.class;
    }
}
