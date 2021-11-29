package org.maktab.hibernate.command.customer;

import org.maktab.hibernate.command.account.AddAccountCommand;
import org.maktab.hibernate.command.base.BaseCommand;
import org.maktab.hibernate.entity.Customer;
import org.maktab.hibernate.entity.Employee;
import org.maktab.hibernate.service.AccountService;
import org.maktab.hibernate.service.CustomerService;
import org.maktab.hibernate.utilities.Input;
import org.maktab.hibernate.utilities.Printer;

public class AddCustomerCommand implements BaseCommand<Employee, Customer>{
    private final CustomerService customerService;

    public AddCustomerCommand(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public Customer execute(Employee teller) {
        Printer.printMessage("Enter customer name:");
        String name = Input.getStringInputValue("");

        Printer.printMessage("Enter customer username:");
        String username = Input.getStringInputValue("");

        Printer.printMessage("Enter customer password:");
        String password = Input.getStringInputValue("");

        Customer customer = new Customer();
        customer.setFullName(name);
        customer.setUserName(username);
        customer.setPassword(password);
        customer.setBankBranch(teller.getBankBranch());

        customerService.saveOrUpdate(customer);
        AccountService accountService = new AccountService();
        AddAccountCommand addAccountCommand = new AddAccountCommand(accountService);
        addAccountCommand.execute(customer);

        return customer;
    }
}
