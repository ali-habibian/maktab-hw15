package org.maktab.hibernate.command.base;

import org.maktab.hibernate.entity.base.BaseEntity;

public interface BaseCommand<T, U extends BaseEntity<Integer>> {
    U execute(T t);
}
