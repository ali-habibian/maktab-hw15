package org.maktab.hibernate.command.employee;

import org.maktab.hibernate.command.base.BaseCommand;
import org.maktab.hibernate.entity.Employee;
import org.maktab.hibernate.service.EmployeeService;

public class RemoveEmployeeCommand implements BaseCommand<Employee, Employee> {
    private EmployeeService employeeService;

    public RemoveEmployeeCommand(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee execute(Employee employee) {
        return null;
    }
}
