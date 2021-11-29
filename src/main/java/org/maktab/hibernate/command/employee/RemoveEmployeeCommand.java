package org.maktab.hibernate.command.employee;

import org.maktab.hibernate.command.base.BaseCommand;
import org.maktab.hibernate.entity.Employee;
import org.maktab.hibernate.exception.DataNotFoundException;
import org.maktab.hibernate.service.EmployeeService;
import org.maktab.hibernate.utilities.Input;
import org.maktab.hibernate.utilities.Printer;

public class RemoveEmployeeCommand implements BaseCommand<Employee, Employee> {
    private EmployeeService employeeService;

    public RemoveEmployeeCommand(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee execute(Employee boss) {
        Printer.printMessage("Enter employee id:");
        Integer employeeId = Input.getIntInputValue("");
        try {
            employeeService.deleteById(employeeId);
            System.out.println("employee deleted");
        } catch (DataNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
