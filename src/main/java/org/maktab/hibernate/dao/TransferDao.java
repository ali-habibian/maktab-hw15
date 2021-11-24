package org.maktab.hibernate.dao;

import org.maktab.hibernate.entity.transaction.Transfer;

public class TransferDao extends AbstractJpaDao<Transfer, Integer> {

    @Override
    public void update(Integer id, Transfer newEntity) {
    }

    @Override
    public Class<Transfer> getEntityClass() {
        return Transfer.class;
    }
}
