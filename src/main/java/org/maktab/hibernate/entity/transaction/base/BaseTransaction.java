package org.maktab.hibernate.entity.transaction.base;

import org.maktab.hibernate.entity.Account;
import org.maktab.hibernate.entity.CreditCard;
import org.maktab.hibernate.entity.base.BaseEntity;

import java.sql.Date;

public interface BaseTransaction extends BaseEntity<Integer> {

    Double getAmount();

    void setAmount(Double amount);

    CreditCard getSourceCreditCard();

    void setSourceCreditCard(CreditCard sourceCreditCard);

    Date getDate();

    void setDate(Date date);

    void execute();
}
