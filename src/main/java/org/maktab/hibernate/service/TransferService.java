package org.maktab.hibernate.service;

import org.maktab.hibernate.dao.AbstractJpaDao;
import org.maktab.hibernate.dao.TransferDao;
import org.maktab.hibernate.entity.transaction.Transfer;

public class TransferService extends AbstractCrudService<Transfer, Integer> {
    public TransferService() {
        setBaseDao(new TransferDao());
    }

    @Override
    public AbstractJpaDao<Transfer, Integer> getBaseDao() {
        return (TransferDao) super.getBaseDao();
    }
}
