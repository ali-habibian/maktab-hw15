package org.maktab.hibernate.entity.transaction.base;

import org.maktab.hibernate.entity.Account;
import org.maktab.hibernate.entity.base.BaseEntity;

import java.sql.Date;

public interface BaseTransaction extends BaseEntity<Integer> {

    Double getAmount();

    void setAmount(Double amount);

    Account getSourceAccount();

    void setSourceAccount(Account sourceAccount);

    Date getDate();

    void setDate(Date date);

    void execute();
}
