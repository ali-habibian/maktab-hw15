package org.maktab.hibernate.dao;

import org.maktab.hibernate.entity.CreditCard;
import org.maktab.hibernate.entity.transaction.Deposit;
import org.maktab.hibernate.entity.transaction.Withdraw;

import javax.persistence.TypedQuery;
import java.util.List;

public class WithdrawDao extends AbstractJpaDao<Withdraw, Integer> {

    @Override
    public void update(Integer id, Withdraw newEntity) {

    }

    @Override
    public Class<Withdraw> getEntityClass() {
        return Withdraw.class;
    }

    public List<Withdraw> findByCardNumber(CreditCard selectedCreditCard) {
        TypedQuery<Withdraw> withdrawTypedQuery = getEntityManager().createQuery(
                        "select w from Withdraw w where w.sourceCreditCard = :cardNumber", Withdraw.class)
                .setParameter("cardNumber", selectedCreditCard);
        return withdrawTypedQuery.getResultList();
    }
}
