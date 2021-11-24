package org.maktab.hibernate.dao;

import org.maktab.hibernate.entity.CreditCard;

public class CreditCardDao extends AbstractJpaDao<CreditCard, Integer> {

    @Override
    public void update(Integer id, CreditCard newEntity) {
        CreditCard creditCard = loadById(id);
        creditCard.setPassword(newEntity.getPassword());
        getEntityManager().merge(creditCard);
    }

    @Override
    public Class<CreditCard> getEntityClass() {
        return CreditCard.class;
    }
}
