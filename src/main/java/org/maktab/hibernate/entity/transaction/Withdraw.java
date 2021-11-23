package org.maktab.hibernate.entity.transaction;

import org.maktab.hibernate.entity.Account;
import org.maktab.hibernate.entity.transaction.base.BaseTransaction;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Withdraw implements BaseTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private Account sourceAccount;

    private Double amount;

    private Date date;

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

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public void setDate(Date date) {
        this.date = date;
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
