package org.maktab.hibernate.command.creditcard;

import org.maktab.hibernate.command.base.BaseCommand;
import org.maktab.hibernate.entity.Customer;
import org.maktab.hibernate.entity.transaction.base.BaseTransaction;
import org.maktab.hibernate.service.CreditCardService;

public class UpdateCreditCardCommand implements BaseCommand<Customer, BaseTransaction> {

    private CreditCardService creditCardService;

    public UpdateCreditCardCommand(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @Override
    public BaseTransaction execute(Customer customer) {
        return null;
    }
}
