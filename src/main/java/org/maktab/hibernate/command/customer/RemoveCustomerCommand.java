package org.maktab.hibernate.command.customer;

import org.maktab.hibernate.command.base.BaseCommand;
import org.maktab.hibernate.entity.Customer;
import org.maktab.hibernate.entity.Employee;
import org.maktab.hibernate.entity.base.BaseEntity;
import org.maktab.hibernate.exception.DataNotFoundException;
import org.maktab.hibernate.service.CustomerService;
import org.maktab.hibernate.utilities.Input;
import org.maktab.hibernate.utilities.Printer;

public class RemoveCustomerCommand implements BaseCommand<Employee, Customer> {
    private CustomerService customerService;

    public RemoveCustomerCommand(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public Customer execute(Employee employee) {
        Printer.printMessage("Enter customer id:");
        Integer customerId = Input.getIntInputValue("");
        try {
            customerService.deleteById(customerId);
            System.out.println("Customer deleted");
        } catch (DataNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
