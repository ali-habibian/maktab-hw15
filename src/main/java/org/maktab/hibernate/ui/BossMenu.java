package org.maktab.hibernate.ui;

import org.maktab.hibernate.command.base.BaseCommand;
import org.maktab.hibernate.command.employee.AddEmployeeCommand;
import org.maktab.hibernate.command.employee.GetAllEmployeesCommand;
import org.maktab.hibernate.command.employee.RemoveEmployeeCommand;
import org.maktab.hibernate.command.employee.UpdateEmployeeCommand;
import org.maktab.hibernate.entity.Employee;
import org.maktab.hibernate.entity.EmployeeRole;
import org.maktab.hibernate.exception.DataNotFoundException;
import org.maktab.hibernate.service.EmployeeService;
import org.maktab.hibernate.utilities.Input;
import org.maktab.hibernate.utilities.Printer;

import java.util.HashMap;
import java.util.Map;

public class BossMenu implements BaseMenu{
    private final EmployeeService employeeService;

    Map<Integer, BaseCommand<Employee, Employee>> employeeCommandsMap = new HashMap<>();

    public BossMenu(EmployeeService employeeService) {
        this.employeeService = employeeService;

        employeeCommandsMap.put(1, new AddEmployeeCommand(employeeService));
        employeeCommandsMap.put(2, new RemoveEmployeeCommand(employeeService));
        employeeCommandsMap.put(3, new UpdateEmployeeCommand(employeeService));
        employeeCommandsMap.put(4, new GetAllEmployeesCommand(employeeService));
    }

    @Override
    public void start() {
        Employee loginBoss = login();

        int command = 0;
        while (command != 5) {
            Printer.printMessage("1. Add New Employee");
            Printer.printMessage("2. Remove Employee");
            Printer.printMessage("3. Edit Employee");
            Printer.printMessage("4. Show All Employees");
            Printer.printMessage("5. Logout");

            command = Input.getIntInputValue("");
            if (command > 5) {
                System.out.println("invalid command");
            } else if (command < 5) {
                employeeCommandsMap.get(command).execute(loginBoss);
            } else {
                System.out.println("Exited");
            }
        }
    }

    private Employee login() {
        Employee boss = null;
        Printer.printMessage("Enter username:");
        String username = Input.getStringInputValue("");

        Printer.printMessage("Enter password:");
        String password = Input.getStringInputValue("");

        try {
            boss = employeeService.getBaseDao().login(username, password);
            if (boss.getRole() != EmployeeRole.BOSS) {
                System.out.println("You are not boss");
                MainMenu mainMenu = new MainMenu();
                mainMenu.start();
            }
        } catch (DataNotFoundException e) {
            System.out.println(e.getMessage());
            login();
        }
        return boss;
    }
}
