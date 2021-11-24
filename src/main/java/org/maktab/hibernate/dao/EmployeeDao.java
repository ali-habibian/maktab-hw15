package org.maktab.hibernate.dao;

import org.maktab.hibernate.entity.Employee;

public class EmployeeDao extends AbstractJpaDao<Employee, Integer> {

    @Override
    public void update(Integer id, Employee newEntity) {

    }

    @Override
    public Class<Employee> getEntityClass() {
        return Employee.class;
    }
}
