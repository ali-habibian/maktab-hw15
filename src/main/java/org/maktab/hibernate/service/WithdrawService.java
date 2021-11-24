package org.maktab.hibernate.service;

import org.maktab.hibernate.dao.AbstractJpaDao;
import org.maktab.hibernate.dao.WithdrawDao;
import org.maktab.hibernate.entity.transaction.Withdraw;

public class WithdrawService extends AbstractCrudService<Withdraw, Integer> {
    public WithdrawService() {
        setBaseDao(new WithdrawDao());
    }

    @Override
    public AbstractJpaDao<Withdraw, Integer> getBaseDao() {
        return (WithdrawDao) super.getBaseDao();
    }
}
