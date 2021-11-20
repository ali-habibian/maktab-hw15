package org.maktab.hibernate.entity.base;

public interface BaseEntity<ID extends Number> {
    ID getId();

    void setId(ID id);
}
