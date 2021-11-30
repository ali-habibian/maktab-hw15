package org.maktab.hibernate.dao;

import org.maktab.hibernate.entity.CreditCard;
import org.maktab.hibernate.entity.transaction.Deposit;
import org.maktab.hibernate.entity.transaction.Transfer;

import javax.persistence.TypedQuery;
import java.sql.Date;
import java.util.List;

public class TransferDao extends AbstractJpaDao<Transfer, Integer> {

    @Override
    public void update(Integer id, Transfer newEntity) {
    }

    @Override
    public Class<Transfer> getEntityClass() {
        return Transfer.class;
    }

    public List<Transfer> findByCardNumber(CreditCard selectedCreditCard) {
        TypedQuery<Transfer> transferTypedQuery = getEntityManager().createQuery(
                        "select t from Transfer t where t.sourceCreditCard = :cardNumber", Transfer.class)
                .setParameter("cardNumber", selectedCreditCard);
        return transferTypedQuery.getResultList();
    }

    public List<Transfer> findByCardNumberAndDate(CreditCard selectedCreditCard, Date date) {
        TypedQuery<Transfer> transferTypedQuery = getEntityManager().createQuery(
                        "select t from Transfer t where t.sourceCreditCard = :cardNumber and t.date >= :date",
                        Transfer.class)
                .setParameter("cardNumber", selectedCreditCard)
                .setParameter("date", date);
        return transferTypedQuery.getResultList();
    }
}
