package org.maktab.hibernate.dao;

import org.maktab.hibernate.entity.transaction.Deposit;

public class DepositDao extends AbstractJpaDao<Deposit, Integer> {

    @Override
    public void update(Integer id, Deposit newEntity) {

    }

    @Override
    public Class<Deposit> getEntityClass() {
        return Deposit.class;
    }
}
