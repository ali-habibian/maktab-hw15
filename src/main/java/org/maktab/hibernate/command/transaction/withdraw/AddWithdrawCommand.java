package org.maktab.hibernate.command.transaction.withdraw;

import org.maktab.hibernate.command.base.BaseCommand;
import org.maktab.hibernate.entity.Account;
import org.maktab.hibernate.entity.CreditCard;
import org.maktab.hibernate.entity.Customer;
import org.maktab.hibernate.entity.transaction.base.BaseTransaction;
import org.maktab.hibernate.service.WithdrawService;
import org.maktab.hibernate.utilities.Input;
import org.maktab.hibernate.utilities.Printer;

import javax.xml.crypto.dsig.TransformException;
import java.util.Objects;
import java.util.Set;

public class AddWithdrawCommand implements BaseCommand<Customer, BaseTransaction> {

    private WithdrawService withdrawService;

    public AddWithdrawCommand(WithdrawService withdrawService) {
        this.withdrawService = withdrawService;
    }

    @Override
    public BaseTransaction execute(Customer customer) {
        Printer.printMessage("Enter credit card id:");
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
            Printer.printMessage("Enter amount:");
            Double amount = Input.getDoubleInputValue("");
            try {
                withdrawService.modifyAccount(selectedCreditCard.getAccount(), amount);
            } catch (TransformException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Password is incorrect");
        }
        return null;
    }
}
