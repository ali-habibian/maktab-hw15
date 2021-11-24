package org.maktab.hibernate.service;

import org.maktab.hibernate.dao.AbstractJpaDao;
import org.maktab.hibernate.dao.BankBranchDao;
import org.maktab.hibernate.entity.BankBranch;

public class BankBranchService extends AbstractCrudService<BankBranch, Integer> {
    public BankBranchService() {
        setBaseDao(new BankBranchDao());
    }

    @Override
    public AbstractJpaDao<BankBranch, Integer> getBaseDao() {
        return (BankBranchDao) super.getBaseDao();
    }
}
