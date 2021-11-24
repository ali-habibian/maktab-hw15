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
        if (entity.getId() == null) {
            baseDao.save(entity);
        } else {
            baseDao.update(entity.getId(), entity);
        }
    }

    public void deleteById(ID id){
        baseDao.delete(id);
    }

    public T loadById(ID id){
        return baseDao.loadById(id);
    }

    public List<T> loadAll(){
        return baseDao.loadAll();
    }
}
