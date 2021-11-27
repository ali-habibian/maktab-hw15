package org.maktab.hibernate.dao;

import org.maktab.hibernate.entity.Account;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class AccountDao extends AbstractJpaDao<Account, Integer> {

    @Override
    public void update(Integer id, Account newEntity) {
        Account account = loadById(id);
        account.setBalance(newEntity.getBalance());
        getEntityManager().merge(account);
    }

    public Account findByAccountNumber(Long accountNumber) {
        TypedQuery<Account> accountTypedQuery = getEntityManager().createQuery(
                        "select a from Account a where a.accountNumber = :accountNumber", Account.class)
                .setParameter("accountNumber", accountNumber);
        if (accountTypedQuery.getSingleResult() == null){
            return null;
        }else {
            return accountTypedQuery.getSingleResult();
        }
    }

    @Override
    public Class<Account> getEntityClass() {
        return Account.class;
    }
}
