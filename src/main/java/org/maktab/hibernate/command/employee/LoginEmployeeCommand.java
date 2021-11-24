package org.maktab.hibernate.command.employee;

import org.maktab.hibernate.command.base.BaseCommand;
import org.maktab.hibernate.entity.Employee;
import org.maktab.hibernate.entity.EmployeeRole;
import org.maktab.hibernate.exception.DataNotFoundException;
import org.maktab.hibernate.service.EmployeeService;
import org.maktab.hibernate.utilities.Input;
import org.maktab.hibernate.utilities.Printer;

public class LoginEmployeeCommand implements BaseCommand {
    private EmployeeService service;

    public LoginEmployeeCommand(EmployeeService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        Printer.printMessage("Enter UserName:");
        String userName = Input.getStringInputValue("");
        Printer.printMessage("Enter Password:");
        String password = Input.getStringInputValue("");
        try {
            Employee employee = service.getBaseDao().login(userName, password);
            if (employee.getRole().equals(EmployeeRole.BOSS)){
                // TODO Boss menu
            }else {
                // TODO Teller menu
            }
        } catch (DataNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
