package org.maktab.hibernate.ui;

import org.maktab.hibernate.command.base.BaseCommand;
import org.maktab.hibernate.command.customer.AddCustomerCommand;
import org.maktab.hibernate.command.customer.GetAllCustomersCommand;
import org.maktab.hibernate.command.customer.RemoveCustomerCommand;
import org.maktab.hibernate.command.customer.UpdateCustomerCommand;
import org.maktab.hibernate.entity.Customer;
import org.maktab.hibernate.entity.Employee;
import org.maktab.hibernate.entity.EmployeeRole;
import org.maktab.hibernate.exception.DataNotFoundException;
import org.maktab.hibernate.service.CustomerService;
import org.maktab.hibernate.service.EmployeeService;
import org.maktab.hibernate.utilities.Input;
import org.maktab.hibernate.utilities.Printer;

import java.util.HashMap;
import java.util.Map;

public class TellerMenu implements BaseMenu {

    private final EmployeeService employeeService;

    Map<Integer, BaseCommand<Employee, Customer>> customerCommandsMap = new HashMap<>();

    public TellerMenu(EmployeeService employeeService, CustomerService customerService) {
        this.employeeService = employeeService;

        customerCommandsMap.put(1, new AddCustomerCommand(customerService));
        customerCommandsMap.put(2, new RemoveCustomerCommand(customerService));
        customerCommandsMap.put(3, new UpdateCustomerCommand(customerService));
        customerCommandsMap.put(4, new GetAllCustomersCommand(customerService));
    }

    @Override
    public void start() {
        Employee loginTeller = login();

        int command = 0;
        while (command != 5) {
            Printer.printMessage("1. Add New Customer");
            Printer.printMessage("2. Remove Customer");
            Printer.printMessage("3. Edit Customer");
            Printer.printMessage("4. Show All Customer");
            Printer.printMessage("5. Logout");

            command = Input.getIntInputValue("");
            if (command > 5) {
                System.out.println("invalid command");
            } else if (command < 5) {
                customerCommandsMap.get(command).execute(loginTeller);
            } else {
                System.out.println("Exited");
            }
        }
    }

    private Employee login() {
        Employee teller = null;
        Printer.printMessage("Enter username:");
        String username = Input.getStringInputValue("");

        Printer.printMessage("Enter password:");
        String password = Input.getStringInputValue("");

        try {
            teller = employeeService.getBaseDao().login(username, password);
            if (teller.getRole() != EmployeeRole.TELLER) {
                System.out.println("You are not teller");
                MainMenu mainMenu = new MainMenu();
                mainMenu.start();
            }
        } catch (DataNotFoundException e) {
            System.out.println(e.getMessage());
            login();
        }
        return teller;
    }
}
