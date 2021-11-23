package org.maktab.hibernate.entity;

import org.maktab.hibernate.entity.base.BaseEntity;

import javax.persistence.*;

@Entity
public class BankBranch implements BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String city;
    private Integer code;

    @OneToOne
    private Employee boss;

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
