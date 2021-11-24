package org.maktab.hibernate.service;

import org.maktab.hibernate.dao.AbstractJpaDao;
import org.maktab.hibernate.dao.DepositDao;
import org.maktab.hibernate.entity.transaction.Deposit;

public class DepositService extends AbstractCrudService<Deposit, Integer> {
    public DepositService() {
        setBaseDao(new DepositDao());
    }

    @Override
    public AbstractJpaDao<Deposit, Integer> getBaseDao() {
        return (DepositDao) super.getBaseDao();
    }
}
