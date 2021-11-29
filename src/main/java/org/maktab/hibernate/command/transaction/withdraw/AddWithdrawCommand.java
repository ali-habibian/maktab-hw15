package org.maktab.hibernate.command.transaction.withdraw;

import org.maktab.hibernate.command.base.BaseCommand;
import org.maktab.hibernate.entity.Customer;
import org.maktab.hibernate.entity.transaction.base.BaseTransaction;
import org.maktab.hibernate.service.WithdrawService;

public class AddWithdrawCommand implements BaseCommand<Customer, BaseTransaction> {

    private WithdrawService withdrawService;

    public AddWithdrawCommand(WithdrawService withdrawService) {
        this.withdrawService = withdrawService;
    }

    @Override
    public BaseTransaction execute(Customer customer) {
        return null;
    }
}
