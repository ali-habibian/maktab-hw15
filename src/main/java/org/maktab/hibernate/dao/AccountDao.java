package org.maktab.hibernate.dao;

import org.maktab.hibernate.entity.Account;

public class AccountDao extends AbstractJpaDao<Account, Integer> {

    @Override
    public void update(Integer id, Account newEntity) {
        Account account = loadById(id);
        account.setBalance(newEntity.getBalance());
        getEntityManager().merge(account);
    }

    @Override
    public Class<Account> getEntityClass() {
        return Account.class;
    }
}
