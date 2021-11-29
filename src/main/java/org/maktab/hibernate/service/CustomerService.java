package org.maktab.hibernate.service;

import org.maktab.hibernate.dao.AbstractJpaDao;
import org.maktab.hibernate.dao.CustomerDao;
import org.maktab.hibernate.entity.Customer;

public class CustomerService extends AbstractCrudService<Customer, Integer> {
    public CustomerService() {
        setBaseDao(new CustomerDao());
    }

    @Override
    public CustomerDao getBaseDao() {
        return (CustomerDao) super.getBaseDao();
    }
}
