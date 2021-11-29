package org.maktab.hibernate.command.employee;

import org.maktab.hibernate.command.base.BaseCommand;
import org.maktab.hibernate.entity.Employee;
import org.maktab.hibernate.entity.EmployeeRole;
import org.maktab.hibernate.service.EmployeeService;
import org.maktab.hibernate.utilities.Input;
import org.maktab.hibernate.utilities.Printer;

public class AddEmployeeCommand implements BaseCommand<Employee, Employee> {

    private EmployeeService employeeService;

    public AddEmployeeCommand(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee execute(Employee boss) {
        Printer.printMessage("Enter employee name:");
        String name = Input.getStringInputValue("");

        Printer.printMessage("Enter employee username:");
        String username = Input.getStringInputValue("");

        Printer.printMessage("Enter employee password:");
        String password = Input.getStringInputValue("");

        Printer.printMessage("Enter employee salary:");
        Double salary = Input.getDoubleInputValue("");

        Employee employee = new Employee();
        employee.setFullName(name);
        employee.setUserName(username);
        employee.setPassword(password);
        employee.setRole(EmployeeRole.TELLER);
        employee.setSalary(salary);
        employee.setBankBranch(boss.getBankBranch());
        employee.setBoss(boss);

        employeeService.saveOrUpdate(employee);
        return employee;
    }
}
