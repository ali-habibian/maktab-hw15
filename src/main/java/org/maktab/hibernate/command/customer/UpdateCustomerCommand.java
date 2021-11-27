package org.maktab.hibernate.command.customer;

import org.maktab.hibernate.command.base.BaseCommand;
import org.maktab.hibernate.entity.Customer;
import org.maktab.hibernate.entity.Employee;
import org.maktab.hibernate.entity.base.BaseEntity;
import org.maktab.hibernate.service.CustomerService;
import org.maktab.hibernate.utilities.Input;
import org.maktab.hibernate.utilities.Printer;

public class UpdateCustomerCommand implements BaseCommand<Employee, Customer> {
    private CustomerService customerService;

    public UpdateCustomerCommand(CustomerService customerService) {
        this.customerService = customerService;
    }


    @Override
    public Customer execute(Employee employee) {
        Printer.printMessage("Enter customer id:");
        Integer customerId = Input.getIntInputValue("");
        Customer customer = customerService.loadById(customerId);
        if (customer != null) {
            Printer.printMessage("Enter customer new username:");
            String newUsername = Input.getStringInputValue("");

            Printer.printMessage("Enter customer new password:");
            String newPassword = Input.getStringInputValue("");

            customer.setUserName(newUsername);
            customer.setPassword(newPassword);

            customerService.saveOrUpdate(customer);
        } else {
            System.out.println("Data Not Found!");
        }

        return customer;
    }
}
