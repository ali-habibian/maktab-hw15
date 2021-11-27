package org.maktab.hibernate.command.customer;

import org.maktab.hibernate.command.base.BaseCommand;
import org.maktab.hibernate.entity.base.BaseEntity;
import org.maktab.hibernate.service.CustomerService;

public class RemoveCustomerCommand implements BaseCommand {
    private CustomerService customerService;

    public RemoveCustomerCommand(CustomerService customerService) {
        this.customerService = customerService;
    }



    @Override
    public Object execute(BaseEntity baseEntity) {
        return null;
    }
}
