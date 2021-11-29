package org.maktab.hibernate.command.transaction;

import org.maktab.hibernate.command.base.BaseCommand;
import org.maktab.hibernate.entity.Customer;
import org.maktab.hibernate.entity.transaction.Deposit;
import org.maktab.hibernate.entity.transaction.base.BaseTransaction;
import org.maktab.hibernate.service.DepositService;
import org.maktab.hibernate.service.TransferService;
import org.maktab.hibernate.service.WithdrawService;

public class GetAllTransactionsCommand implements BaseCommand<Customer, BaseTransaction> {
    private DepositService depositService;
    private TransferService transferService;
    private WithdrawService withdrawService;

    public GetAllTransactionsCommand(DepositService depositService, TransferService transferService, WithdrawService withdrawService) {
        this.depositService = depositService;
        this.transferService = transferService;
        this.withdrawService = withdrawService;
    }

    @Override
    public BaseTransaction execute(Customer customer) {
        return null;
    }
}
