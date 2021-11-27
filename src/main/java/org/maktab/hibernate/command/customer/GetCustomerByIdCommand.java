package org.maktab.hibernate.command.customer;

import org.maktab.hibernate.command.base.BaseCommand;
import org.maktab.hibernate.entity.Customer;
import org.maktab.hibernate.entity.Employee;
import org.maktab.hibernate.entity.base.BaseEntity;

public class GetCustomerByIdCommand implements BaseCommand<Employee, Customer> {

    @Override
    public Customer execute(Employee employee) {
        return null;
    }
}
