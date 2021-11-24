package org.maktab.hibernate.ui;

import org.maktab.hibernate.command.base.BaseCommand;
import org.maktab.hibernate.command.customer.CustomerCommands;
import org.maktab.hibernate.command.employee.EmployeeCommands;
import org.maktab.hibernate.service.*;
import org.maktab.hibernate.utilities.Input;
import org.maktab.hibernate.utilities.Printer;

import java.util.HashMap;
import java.util.Map;

public class MainMenu {
    CustomerService customerService;
    EmployeeService employeeService;

    public MainMenu() {
        this.customerService = new CustomerService();
        this.employeeService = new EmployeeService();
    }

    public void start(){
        Map<Integer, BaseCommand> mainMenuCommandsMap = new HashMap<>();
        mainMenuCommandsMap.put(1, new EmployeeCommands(employeeService));
        mainMenuCommandsMap.put(2, new EmployeeCommands(employeeService));
        mainMenuCommandsMap.put(3, new CustomerCommands(customerService));

        int command = 0;
        while (command != 4) {
            Printer.printMessage("1. Login As Boss");
            Printer.printMessage("2. Login As Teller");
            Printer.printMessage("3. Login As Customer");
            Printer.printMessage("4. Exit");
            command = Input.getIntInputValue("");
            if (command > 4) {
                System.out.println("invalid command");
            } else if (command < 4) {
                mainMenuCommandsMap.get(command).execute();
            } else {
                System.out.println("Exited");
            }
        }    }
}
