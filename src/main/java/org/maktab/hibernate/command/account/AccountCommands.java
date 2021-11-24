package org.maktab.hibernate.command.account;

import net.bytebuddy.asm.Advice;
import org.maktab.hibernate.command.base.BaseCommand;
import org.maktab.hibernate.command.creditcard.AddCreditCardCommand;
import org.maktab.hibernate.service.AccountService;
import org.maktab.hibernate.utilities.Input;
import org.maktab.hibernate.utilities.Printer;

public class AccountCommands implements BaseCommand {
    private AccountService service;

    public AccountCommands(AccountService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        Printer.printMessage("Enter initial balance:");
        Double balance = Input.getDoubleInputValue("");
        AddCreditCardCommand creditCardCommand = new AddCreditCardCommand();
        creditCardCommand.execute();
    }
}
