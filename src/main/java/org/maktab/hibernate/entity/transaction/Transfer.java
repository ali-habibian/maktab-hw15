package org.maktab.hibernate.entity.transaction;

import org.maktab.hibernate.entity.Account;
import org.maktab.hibernate.entity.transaction.base.BaseTransaction;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Transfer implements BaseTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private Account sourceAccount;

    @OneToOne
    private Account destAccount;

    private Double amount;

    private Date date;

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Account getSourceAccount() {
        return sourceAccount;
    }

    @Override
    public void setSourceAccount(Account sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public Account getDestAccount() {
        return destAccount;
    }

    public void setDestAccount(Account destAccount) {
        this.destAccount = destAccount;
    }

    @Override
    public Double getAmount() {
        return amount;
    }

    @Override
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public void execute() {

    }
}
