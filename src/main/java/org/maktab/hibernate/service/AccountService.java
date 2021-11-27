package org.maktab.hibernate.service;

import org.maktab.hibernate.dao.AbstractJpaDao;
import org.maktab.hibernate.dao.AccountDao;
import org.maktab.hibernate.entity.Account;

public class AccountService extends AbstractCrudService<Account, Integer> {
    public AccountService() {
        setBaseDao(new AccountDao());
    }

    public Account findByAccountNumber(Long accountNumber) {
        return getBaseDao().findByAccountNumber(accountNumber);
    }

    @Override
    public AccountDao getBaseDao() {
        return (AccountDao) super.getBaseDao();
    }
}
