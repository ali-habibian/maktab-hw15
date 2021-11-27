package org.maktab.hibernate.command.customer;

import org.maktab.hibernate.command.base.BaseCommand;
import org.maktab.hibernate.entity.Customer;
import org.maktab.hibernate.entity.Employee;
import org.maktab.hibernate.service.CustomerService;

public class GetAllCustomersCommand implements BaseCommand<Employee> {
    private CustomerService customerService;

    public GetAllCustomersCommand(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public Customer execute(Employee boss) {
        return null;
    }
}
