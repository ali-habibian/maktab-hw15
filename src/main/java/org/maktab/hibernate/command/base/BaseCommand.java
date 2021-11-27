package org.maktab.hibernate.command.base;

import org.maktab.hibernate.entity.base.BaseEntity;

public interface BaseCommand<T extends BaseEntity<Integer>> {
   <U> U execute(T t);
}
