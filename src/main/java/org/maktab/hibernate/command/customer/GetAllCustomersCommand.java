package org.maktab.hibernate.command.customer;

import org.maktab.hibernate.command.base.BaseCommand;
import org.maktab.hibernate.entity.Customer;
import org.maktab.hibernate.entity.Employee;
import org.maktab.hibernate.service.CustomerService;

import java.util.List;

public class GetAllCustomersCommand implements BaseCommand<Employee, Customer> {
    private CustomerService customerService;

    public GetAllCustomersCommand(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public Customer execute(Employee teller) {
        List<Customer> customers = customerService.loadAll();
        customers.forEach(System.out::println);
        return null;
    }
}
