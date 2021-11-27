package org.maktab.hibernate.service;

import org.maktab.hibernate.dao.AbstractJpaDao;
import org.maktab.hibernate.entity.base.BaseEntity;

import java.util.List;

public class AbstractCrudService<T extends BaseEntity<ID>, ID extends Number> {
    private AbstractJpaDao<T, ID> baseDao;

    public void setBaseDao(AbstractJpaDao<T, ID> baseDao) {
        this.baseDao = baseDao;
    }

    public AbstractJpaDao<T, ID> getBaseDao() {
        return baseDao;
    }

    public void saveOrUpdate(T entity) {
        baseDao.getEntityManager().getTransaction().begin();
        if (entity.getId() == null) {
            baseDao.save(entity);
        } else {
            baseDao.update(entity.getId(), entity);
        }
        baseDao.getEntityManager().getTransaction().commit();
    }

    public void deleteById(ID id) {
        baseDao.getEntityManager().getTransaction().begin();
        baseDao.delete(id);
        baseDao.getEntityManager().getTransaction().commit();
    }

    public T loadById(ID id) {
        baseDao.getEntityManager().getTransaction().begin();
        T t = baseDao.loadById(id);
        baseDao.getEntityManager().getTransaction().commit();
        return t;
    }

    public List<T> loadAll() {
        baseDao.getEntityManager().getTransaction().begin();
        return baseDao.loadAll();
    }
}
