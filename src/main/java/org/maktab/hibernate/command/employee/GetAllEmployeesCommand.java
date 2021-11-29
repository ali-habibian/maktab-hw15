package org.maktab.hibernate.command.employee;

import org.maktab.hibernate.command.base.BaseCommand;
import org.maktab.hibernate.entity.Employee;
import org.maktab.hibernate.service.EmployeeService;

import java.util.List;

public class GetAllEmployeesCommand implements BaseCommand<Employee, Employee> {

    private EmployeeService employeeService;

    public GetAllEmployeesCommand(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee execute(Employee boss) {
        List<Employee> employees = employeeService.loadAll();
        employees.forEach(System.out::println);
        return null;
    }
}
