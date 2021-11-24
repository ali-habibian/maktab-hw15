package org.maktab.hibernate.dao;


import org.maktab.hibernate.entity.base.BaseEntity;

import javax.persistence.*;
import java.util.List;

public abstract class AbstractJpaDao<T extends BaseEntity<ID>, ID extends Number> {
    private static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("BankManagement");
    private static final EntityManager MANAGER = FACTORY.createEntityManager();

    public void save(T entity) {
        MANAGER.persist(entity);
    }

    public abstract void update(ID id, T newEntity);

    public void delete(ID id) {
        T entity = loadById(id);
        MANAGER.remove(entity);
    }

    public List<T> loadAll() {
        TypedQuery<T> query = MANAGER.createQuery(
                "select e from " + getEntityClass().getSimpleName() + " e", getEntityClass()
        );
        return query.getResultList();
    }

    public T loadById(ID id) {
        return MANAGER.find(getEntityClass(), id);
    }

    public EntityTransaction getTransaction() {
        return MANAGER.getTransaction();
    }

    public EntityManager getEntityManager() {
        return MANAGER;
    }

    public abstract Class<T> getEntityClass();
}
