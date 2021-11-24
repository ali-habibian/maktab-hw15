package org.maktab.hibernate.service;

import org.maktab.hibernate.dao.AbstractJpaDao;
import org.maktab.hibernate.dao.AccountDao;
import org.maktab.hibernate.entity.Account;

public class AccountService extends AbstractCrudService<Account, Integer> {
    public AccountService() {
        setBaseDao(new AccountDao());
    }

    @Override
    public AbstractJpaDao<Account, Integer> getBaseDao() {
        return (AccountDao) super.getBaseDao();
    }
}
