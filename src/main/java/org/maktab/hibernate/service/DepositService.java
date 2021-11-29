package org.maktab.hibernate.service;

import org.maktab.hibernate.dao.DepositDao;
import org.maktab.hibernate.entity.Account;
import org.maktab.hibernate.entity.transaction.Deposit;

public class DepositService extends AbstractCrudService<Deposit, Integer> {
    public DepositService() {
        setBaseDao(new DepositDao());
    }

    public void modifyAccount(Account account, Double amount) {
        Double newBalance = account.getBalance() + amount;
        account.setBalance(newBalance);
        AccountService accountService = new AccountService();
        accountService.saveOrUpdate(account);
        Deposit deposit = new Deposit();
        deposit.setAmount(amount);
        deposit.setSourceCreditCard(account.getCreditCard());
        this.saveOrUpdate(deposit);
    }

    @Override
    public DepositDao getBaseDao() {
        return (DepositDao) super.getBaseDao();
    }
}
