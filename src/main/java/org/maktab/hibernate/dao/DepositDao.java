package org.maktab.hibernate.dao;

import org.maktab.hibernate.entity.CreditCard;
import org.maktab.hibernate.entity.transaction.Deposit;

import javax.persistence.TypedQuery;
import java.sql.Date;
import java.util.List;

public class DepositDao extends AbstractJpaDao<Deposit, Integer> {

    @Override
    public void update(Integer id, Deposit newEntity) {

    }

    @Override
    public Class<Deposit> getEntityClass() {
        return Deposit.class;
    }

    public List<Deposit> findByCardNumber(CreditCard selectedCreditCard) {
        TypedQuery<Deposit> depositTypedQuery = getEntityManager().createQuery(
                        "select d from Deposit d where d.sourceCreditCard = :cardNumber", Deposit.class)
                .setParameter("cardNumber", selectedCreditCard);
        return depositTypedQuery.getResultList();
    }

    public List<Deposit> findByCardNumberAndDate(CreditCard selectedCreditCard, Date date) {
        TypedQuery<Deposit> depositTypedQuery = getEntityManager().createQuery(
                        "select d from Deposit d where d.sourceCreditCard = :cardNumber and d.date >= :date",
                        Deposit.class)
                .setParameter("cardNumber", selectedCreditCard)
                .setParameter("date", date);
        return depositTypedQuery.getResultList();
    }
}
