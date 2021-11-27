package org.maktab.hibernate.dao;

import org.maktab.hibernate.entity.Account;
import org.maktab.hibernate.entity.CreditCard;

import javax.persistence.TypedQuery;

public class CreditCardDao extends AbstractJpaDao<CreditCard, Integer> {

    @Override
    public void update(Integer id, CreditCard newEntity) {
        CreditCard creditCard = loadById(id);
        creditCard.setPassword(newEntity.getPassword());
        getEntityManager().merge(creditCard);
    }

    public CreditCard findByCreditCardNumber(Long creditCard) {
        TypedQuery<CreditCard> creditCardTypedQuery = getEntityManager().createQuery(
                        "select c from CreditCard c where c.cardNumber = :cardNumber", CreditCard.class)
                .setParameter("cardNumber", creditCard);
        return creditCardTypedQuery.getSingleResult();
    }

    @Override
    public Class<CreditCard> getEntityClass() {
        return CreditCard.class;
    }
}
