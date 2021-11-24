package org.maktab.hibernate.service;

import org.maktab.hibernate.dao.AbstractJpaDao;
import org.maktab.hibernate.dao.EmployeeDao;
import org.maktab.hibernate.entity.Employee;

public class EmployeeService extends AbstractCrudService<Employee, Integer> {
    public EmployeeService() {
        setBaseDao(new EmployeeDao());
    }

    @Override
    public AbstractJpaDao<Employee, Integer> getBaseDao() {
        return (EmployeeDao) super.getBaseDao();
    }
}
