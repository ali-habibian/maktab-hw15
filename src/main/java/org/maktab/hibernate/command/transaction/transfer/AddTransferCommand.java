package org.maktab.hibernate.command.transaction.transfer;

import org.maktab.hibernate.command.base.BaseCommand;
import org.maktab.hibernate.entity.Customer;
import org.maktab.hibernate.entity.transaction.base.BaseTransaction;
import org.maktab.hibernate.service.TransferService;

public class AddTransferCommand implements BaseCommand<Customer, BaseTransaction> {

    private TransferService transferService;

    public AddTransferCommand(TransferService transferService) {
        this.transferService = transferService;
    }

    @Override
    public BaseTransaction execute(Customer customer) {
        return null;
    }
}
