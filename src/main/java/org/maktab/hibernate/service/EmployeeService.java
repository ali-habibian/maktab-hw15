package org.maktab.hibernate.service;

import org.maktab.hibernate.dao.EmployeeDao;
import org.maktab.hibernate.entity.Employee;

public class EmployeeService extends AbstractCrudService<Employee, Integer> {
    public EmployeeService() {
        setBaseDao(new EmployeeDao());
    }

    @Override
    public EmployeeDao getBaseDao() {
        return (EmployeeDao) super.getBaseDao();
    }
}
