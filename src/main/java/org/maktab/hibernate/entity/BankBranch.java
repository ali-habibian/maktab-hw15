package org.maktab.hibernate.entity;

import org.maktab.hibernate.entity.base.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class BankBranch implements BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String city;
    private Integer code;

    @OneToOne
    private Employee boss;

    @OneToMany(mappedBy = "bankBranch", cascade = CascadeType.ALL)
    private Set<Employee> tellers;

    @OneToMany(mappedBy = "bankBranch", cascade = CascadeType.ALL)
    private Set<Account> accounts;

    @OneToMany(mappedBy = "bankBranch", cascade = CascadeType.ALL)
    private Set<Customer> customers;

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Employee getBoss() {
        return boss;
    }

    public void setBoss(Employee boss) {
        this.boss = boss;
    }

    public Set<Employee> getTellers() {
        return tellers;
    }

    public void setTellers(Set<Employee> tellers) {
        this.tellers = tellers;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}
