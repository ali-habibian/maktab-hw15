package org.maktab.hibernate.dao;

import org.maktab.hibernate.entity.CreditCard;
import org.maktab.hibernate.entity.transaction.Deposit;
import org.maktab.hibernate.entity.transaction.Withdraw;

import javax.persistence.TypedQuery;
import java.sql.Date;
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

    public List<Withdraw> findByCardNumberAndDate(CreditCard selectedCreditCard, Date date) {
        TypedQuery<Withdraw> withdrawTypedQuery = getEntityManager().createQuery(
                        "select w from Withdraw w where w.sourceCreditCard = :cardNumber and w.date >= :date",
                        Withdraw.class)
                .setParameter("cardNumber", selectedCreditCard)
                .setParameter("date", date);
        return withdrawTypedQuery.getResultList();
    }
}
