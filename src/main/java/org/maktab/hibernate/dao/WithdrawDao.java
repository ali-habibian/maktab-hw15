package org.maktab.hibernate.dao;

import org.maktab.hibernate.entity.transaction.Withdraw;

public class WithdrawDao extends AbstractJpaDao<Withdraw, Integer> {

    @Override
    public void update(Integer id, Withdraw newEntity) {

    }

    @Override
    public Class<Withdraw> getEntityClass() {
        return Withdraw.class;
    }
}
