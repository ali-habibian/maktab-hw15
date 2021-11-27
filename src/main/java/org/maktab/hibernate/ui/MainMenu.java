package org.maktab.hibernate.ui;

import org.maktab.hibernate.service.CustomerService;
import org.maktab.hibernate.service.EmployeeService;
import org.maktab.hibernate.utilities.Input;
import org.maktab.hibernate.utilities.Printer;

import java.util.HashMap;
import java.util.Map;

public class MainMenu implements BaseMenu {
    CustomerService customerService;
    EmployeeService employeeService;

    public MainMenu() {
        this.customerService = new CustomerService();
        this.employeeService = new EmployeeService();
    }

    @Override
    public void start() {
        Map<Integer, BaseMenu> mainMenuMap = new HashMap<>();
        mainMenuMap.put(1, new BossMenu());
        mainMenuMap.put(2, new TellerMenu(employeeService, customerService));
        mainMenuMap.put(3, new CustomerMenu());

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
                mainMenuMap.get(command).start();
            } else {
                System.out.println("Exited");
            }
        }
    }
}
