package org.maktab.hibernate.entity.transaction;

import org.hibernate.annotations.CreationTimestamp;
import org.maktab.hibernate.entity.Account;
import org.maktab.hibernate.entity.CreditCard;
import org.maktab.hibernate.entity.transaction.base.BaseTransaction;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Deposit implements BaseTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private CreditCard sourceCreditCard;

    private Double amount;

    @CreationTimestamp
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
    public Double getAmount() {
        return amount;
    }

    @Override
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public CreditCard getSourceCreditCard() {
        return sourceCreditCard;
    }

    @Override
    public void setSourceCreditCard(CreditCard sourceCreditCard) {
        this.sourceCreditCard = sourceCreditCard;
    }

    @Override
    public void execute() {

    }
}
