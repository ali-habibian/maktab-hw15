package org.maktab.hibernate.service;

import org.maktab.hibernate.dao.AbstractJpaDao;
import org.maktab.hibernate.dao.CreditCardDao;
import org.maktab.hibernate.entity.Account;
import org.maktab.hibernate.entity.CreditCard;

public class CreditCardService extends AbstractCrudService<CreditCard, Integer> {
    public CreditCardService() {
        setBaseDao(new CreditCardDao());
    }

    public CreditCard findByCardNumber(Long cardNumber) {
        return getBaseDao().findByCreditCardNumber(cardNumber);
    }

    @Override
    public CreditCardDao getBaseDao() {
        return (CreditCardDao) super.getBaseDao();
    }
}
