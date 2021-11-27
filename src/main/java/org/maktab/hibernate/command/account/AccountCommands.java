package org.maktab.hibernate.command.account;

import net.bytebuddy.asm.Advice;
import org.maktab.hibernate.command.base.BaseCommand;
import org.maktab.hibernate.command.creditcard.AddCreditCardCommand;
import org.maktab.hibernate.service.AccountService;
import org.maktab.hibernate.utilities.Input;
import org.maktab.hibernate.utilities.Printer;

public class AccountCommands {
    private AccountService service;

    public AccountCommands(AccountService service) {
        this.service = service;
    }

    public void execute() {

    }
}
