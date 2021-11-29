package org.maktab.hibernate.command.transaction.transfer;

import org.maktab.hibernate.command.base.BaseCommand;
import org.maktab.hibernate.entity.Account;
import org.maktab.hibernate.entity.CreditCard;
import org.maktab.hibernate.entity.Customer;
import org.maktab.hibernate.entity.transaction.base.BaseTransaction;
import org.maktab.hibernate.service.CreditCardService;
import org.maktab.hibernate.service.TransferService;
import org.maktab.hibernate.utilities.Input;
import org.maktab.hibernate.utilities.Printer;

import javax.persistence.NoResultException;
import javax.xml.crypto.dsig.TransformException;
import java.util.Objects;
import java.util.Set;

public class AddTransferCommand implements BaseCommand<Customer, BaseTransaction> {

    private final TransferService transferService;

    public AddTransferCommand(TransferService transferService) {
        this.transferService = transferService;
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
            Printer.printMessage("Enter amount:");
            Double amount = Input.getDoubleInputValue("");

            Printer.printMessage("Enter dest credit card number:");
            Long destCardNumber = Input.getLongInputValue("");
            CreditCardService cardService = new CreditCardService();
            try {
                CreditCard destCard = cardService.findByCardNumber(destCardNumber);

                try {
                    transferService.modifyAccount(selectedCreditCard.getAccount(), destCard.getAccount(), amount);
                } catch (TransformException e) {
                    System.out.println(e.getMessage());
                }

            }catch (NoResultException e){
                System.out.println(e.getMessage());
            }

        } else {
            System.out.println("Password is incorrect");
        }
        return null;
    }
}
