package org.maktab.hibernate.ui;

import org.maktab.hibernate.command.base.BaseCommand;
import org.maktab.hibernate.entity.Customer;
import org.maktab.hibernate.entity.Employee;
import org.maktab.hibernate.entity.EmployeeRole;
import org.maktab.hibernate.entity.transaction.base.BaseTransaction;
import org.maktab.hibernate.exception.DataNotFoundException;
import org.maktab.hibernate.service.CustomerService;
import org.maktab.hibernate.service.DepositService;
import org.maktab.hibernate.service.TransferService;
import org.maktab.hibernate.service.WithdrawService;
import org.maktab.hibernate.utilities.Input;
import org.maktab.hibernate.utilities.Printer;

import java.util.HashMap;
import java.util.Map;

public class CustomerMenu implements BaseMenu {

    private final CustomerService customerService;
    private final DepositService depositService;
    private final WithdrawService withdrawService;
    private final TransferService transferService;

    Map<Integer, BaseCommand<Customer, BaseTransaction>> transactionCommandsMap = new HashMap<>();

    public CustomerMenu() {
        this.customerService = new CustomerService();
        this.depositService = new DepositService();
        this.withdrawService = new WithdrawService();
        this.transferService = new TransferService();
    }

    @Override
    public void start() {
        Customer loginCustomer = login();

        int command = 0;
        while (command != 6) {
            Printer.printMessage("1. Deposit Money");
            Printer.printMessage("2. Withdraw Money");
            Printer.printMessage("3. Transfer Money");
            Printer.printMessage("4. Show All Transactions");
            Printer.printMessage("5. Change card password");
            Printer.printMessage("6. Logout");

            command = Input.getIntInputValue("");
            if (command > 6) {
                System.out.println("invalid command");
            } else if (command < 6) {
                transactionCommandsMap.get(command).execute(loginCustomer);
            } else {
                System.out.println("Exited");
            }
        }
    }

    private Customer login() {
        Customer customer = null;
        Printer.printMessage("Enter username:");
        String username = Input.getStringInputValue("");

        Printer.printMessage("Enter password:");
        String password = Input.getStringInputValue("");

        try {
            customer = customerService.getBaseDao().login(username, password);
        } catch (DataNotFoundException e) {
            System.out.println(e.getMessage());
            login();
        }
        return customer;
    }
}
