package org.maktab.hibernate.service;

import org.maktab.hibernate.dao.AbstractJpaDao;
import org.maktab.hibernate.dao.WithdrawDao;
import org.maktab.hibernate.entity.Account;
import org.maktab.hibernate.entity.transaction.Deposit;
import org.maktab.hibernate.entity.transaction.Withdraw;

import javax.xml.crypto.dsig.TransformException;

public class WithdrawService extends AbstractCrudService<Withdraw, Integer> {
    public WithdrawService() {
        setBaseDao(new WithdrawDao());
    }

    @Override
    public AbstractJpaDao<Withdraw, Integer> getBaseDao() {
        return (WithdrawDao) super.getBaseDao();
    }

    public void modifyAccount(Account account, Double amount) throws TransformException {
        if (account.getBalance() < amount)
            throw new TransformException("Balance is not enough");
        Double newBalance = account.getBalance() - amount;
        account.setBalance(newBalance);
        AccountService accountService = new AccountService();
        accountService.saveOrUpdate(account);
        Withdraw withdraw = new Withdraw();
        withdraw.setAmount(amount);
        withdraw.setSourceCreditCard(account.getCreditCard());
        this.saveOrUpdate(withdraw);
    }
}
