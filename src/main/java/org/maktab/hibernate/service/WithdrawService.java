package org.maktab.hibernate.service;

import org.maktab.hibernate.dao.WithdrawDao;
import org.maktab.hibernate.entity.Account;
import org.maktab.hibernate.entity.CreditCard;
import org.maktab.hibernate.entity.transaction.Withdraw;

import javax.xml.crypto.dsig.TransformException;
import java.sql.Date;
import java.util.List;

public class WithdrawService extends AbstractCrudService<Withdraw, Integer> {
    public WithdrawService() {
        setBaseDao(new WithdrawDao());
    }

    @Override
    public WithdrawDao getBaseDao() {
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

    public List<Withdraw> findByCardNumber(CreditCard selectedCreditCard) {
        return getBaseDao().findByCardNumber(selectedCreditCard);
    }

    public List<Withdraw> findByCardNumberAndDate(CreditCard selectedCreditCard, Date date) {
        return getBaseDao().findByCardNumberAndDate(selectedCreditCard, date);
    }
}
