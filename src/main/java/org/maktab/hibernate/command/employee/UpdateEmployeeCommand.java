package org.maktab.hibernate.command.employee;

import org.maktab.hibernate.command.base.BaseCommand;
import org.maktab.hibernate.entity.Employee;
import org.maktab.hibernate.service.EmployeeService;
import org.maktab.hibernate.utilities.Input;
import org.maktab.hibernate.utilities.Printer;

public class UpdateEmployeeCommand implements BaseCommand<Employee, Employee> {

    private EmployeeService employeeService;

    public UpdateEmployeeCommand(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee execute(Employee boss) {
        Printer.printMessage("Enter employee id:");
        Integer employeeId = Input.getIntInputValue("");
        Employee teller = employeeService.loadById(employeeId);
        if (teller != null) {
            Printer.printMessage("Enter teller new username:");
            String newUsername = Input.getStringInputValue("");

            Printer.printMessage("Enter teller new password:");
            String newPassword = Input.getStringInputValue("");

            Printer.printMessage("Enter teller new salary:");
            Double salary = Input.getDoubleInputValue("");

            teller.setUserName(newUsername);
            teller.setPassword(newPassword);
            teller.setSalary(salary);

            employeeService.saveOrUpdate(teller);
        } else {
            System.out.println("Data Not Found!");
        }

        return teller;
    }
}
