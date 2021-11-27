package org.maktab.hibernate.command.account;

import org.maktab.hibernate.command.base.BaseCommand;
import org.maktab.hibernate.command.creditcard.AddCreditCardCommand;
import org.maktab.hibernate.entity.Account;
import org.maktab.hibernate.entity.CreditCard;
import org.maktab.hibernate.entity.Customer;
import org.maktab.hibernate.service.AccountService;
import org.maktab.hibernate.service.CreditCardService;
import org.maktab.hibernate.utilities.Input;
import org.maktab.hibernate.utilities.Printer;

import javax.persistence.NoResultException;

public class AddAccountCommand implements BaseCommand<Customer, Account> {

    private AccountService accountService;

    public AddAccountCommand(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public Account execute(Customer customer) {
        Account account = new Account();

        Printer.printMessage("Enter initial balance:");
        Double balance = Input.getDoubleInputValue("");
        account.setBalance(balance);

        // Set AccountNumber
        account.setAccountNumber();
        Account byAccountNumber;
        try {
            byAccountNumber = accountService.findByAccountNumber(account.getAccountNumber());
            while (byAccountNumber != null) {
                account.setAccountNumber();
                byAccountNumber = accountService.findByAccountNumber(account.getAccountNumber());
            }
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }

        CreditCardService cardService = new CreditCardService();
        AddCreditCardCommand addCreditCardCommand = new AddCreditCardCommand(cardService);
        CreditCard creditCard = addCreditCardCommand.execute(account);
        account.setCreditCard(creditCard);
        account.setCustomer(customer);
        account.setBankBranch(customer.getBankBranch());

        accountService.saveOrUpdate(account);
        return accountService.findByAccountNumber(account.getAccountNumber());
    }
}
