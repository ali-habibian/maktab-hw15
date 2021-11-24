package org.maktab.hibernate.dao;

import org.maktab.hibernate.entity.BankBranch;

public class BankBranchDao extends AbstractJpaDao<BankBranch, Integer> {

    @Override
    public void update(Integer id, BankBranch newEntity) {
        BankBranch bankBranch = loadById(id);
        bankBranch.setBoss(newEntity.getBoss());
        getEntityManager().merge(bankBranch);
    }

    @Override
    public Class<BankBranch> getEntityClass() {
        return BankBranch.class;
    }
}
