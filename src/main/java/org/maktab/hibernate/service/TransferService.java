package org.maktab.hibernate.service;

import org.maktab.hibernate.dao.TransferDao;
import org.maktab.hibernate.entity.Account;
import org.maktab.hibernate.entity.CreditCard;
import org.maktab.hibernate.entity.transaction.Transfer;

import javax.xml.crypto.dsig.TransformException;
import java.sql.Date;
import java.util.List;

public class TransferService extends AbstractCrudService<Transfer, Integer> {
    public TransferService() {
        setBaseDao(new TransferDao());
    }

    @Override
    public TransferDao getBaseDao() {
        return (TransferDao) super.getBaseDao();
    }

    public void modifyAccount(Account sourceAccount, Account destAccount, Double amount) throws TransformException {
        if (sourceAccount.getBalance() < amount)
            throw new TransformException("Balance is not enough");

        Double newSourceBalance = sourceAccount.getBalance() - amount;
        Double newDestBalance = destAccount.getBalance() + amount;
        sourceAccount.setBalance(newSourceBalance);
        destAccount.setBalance(newDestBalance);

        AccountService accountService = new AccountService();
        accountService.saveOrUpdate(sourceAccount);
        accountService.saveOrUpdate(destAccount);

        Transfer transfer = new Transfer();
        transfer.setAmount(amount);
        transfer.setSourceCreditCard(sourceAccount.getCreditCard());
        transfer.setDestCreditCard(destAccount.getCreditCard());
        this.saveOrUpdate(transfer);
    }

    public List<Transfer> findByCardNumber(CreditCard selectedCreditCard) {
        return getBaseDao().findByCardNumber(selectedCreditCard);
    }

    public List<Transfer> findByCardNumberAndDate(CreditCard selectedCreditCard, Date date) {
        return getBaseDao().findByCardNumberAndDate(selectedCreditCard, date);
    }
}
