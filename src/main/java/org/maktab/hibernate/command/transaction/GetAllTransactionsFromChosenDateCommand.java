package org.maktab.hibernate.command.transaction;

import org.maktab.hibernate.command.base.BaseCommand;
import org.maktab.hibernate.entity.Account;
import org.maktab.hibernate.entity.CreditCard;
import org.maktab.hibernate.entity.Customer;
import org.maktab.hibernate.entity.transaction.Deposit;
import org.maktab.hibernate.entity.transaction.Transfer;
import org.maktab.hibernate.entity.transaction.Withdraw;
import org.maktab.hibernate.entity.transaction.base.BaseTransaction;
import org.maktab.hibernate.service.DepositService;
import org.maktab.hibernate.service.TransferService;
import org.maktab.hibernate.service.WithdrawService;
import org.maktab.hibernate.utilities.Input;
import org.maktab.hibernate.utilities.Printer;

import javax.persistence.NoResultException;
import java.sql.Date;
import java.util.*;

public class GetAllTransactionsFromChosenDateCommand implements BaseCommand<Customer, BaseTransaction> {
    private DepositService depositService;
    private TransferService transferService;
    private WithdrawService withdrawService;

    public GetAllTransactionsFromChosenDateCommand(DepositService depositService, TransferService transferService, WithdrawService withdrawService) {
        this.depositService = depositService;
        this.transferService = transferService;
        this.withdrawService = withdrawService;
    }

    @Override
    public BaseTransaction execute(Customer customer) {
        Printer.printMessage("Enter your credit card id:");
        Set<Account> accounts = customer.getAccounts();
        accounts.forEach((a) -> System.out.println(a.getCreditCard()));
        Integer creditCardId = Input.getIntInputValue("");
        CreditCard selectedCreditCard = null;
        for (Account account : accounts) {
            if (Objects.equals(account.getCreditCard().getId(), creditCardId)) {
                selectedCreditCard = account.getCreditCard();
            }
        }

        Printer.printMessage("Enter credit card password:");
        String password = Input.getStringInputValue("");

        if (selectedCreditCard != null && selectedCreditCard.getPassword().equals(password)) {
            Date date = generateDate();

            List<Deposit> deposits = null;
            List<Withdraw> withdraws = null;
            List<Transfer> transfers = null;
            try {
                deposits = depositService.findByCardNumberAndDate(selectedCreditCard, date);
            } catch (NoResultException e) {
                System.out.println("Not find Deposit transaction");
            }

            try {
                withdraws = withdrawService.findByCardNumberAndDate(selectedCreditCard, date);
            } catch (NoResultException e) {
                System.out.println("Not find Withdraw transaction");
            }

            try {
                transfers = transferService.findByCardNumberAndDate(selectedCreditCard, date);
            } catch (NoResultException e) {
                System.out.println("Not find Transfer transaction");
            }

            List<BaseTransaction> transactions = new ArrayList<>();
            if (deposits != null)
                transactions.addAll(deposits);
            if (withdraws != null)
                transactions.addAll(withdraws);
            if (transfers != null)
                transactions.addAll(transfers);

            transactions.stream()
                    .sorted(((t1, t2) -> t2.getDate().compareTo(t1.getDate())))
                    .forEach(System.out::println);
        } else {
            System.out.println("Password is incorrect");
        }
        return null;
    }

    private static Date generateDate() {
        Printer.printMessage("Enter month:");
        int month = Input.getIntInputValue("");

        Printer.printMessage("Enter day:");
        int day = Input.getIntInputValue("");

        Printer.printMessage("Enter year:");
        int year = Input.getIntInputValue("");

        String strDate = year + "-" + month + "-" + day;

        return Date.valueOf(strDate);
    }
}
