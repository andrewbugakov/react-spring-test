package com.bugakov.moneymanagment.dao;

import com.bugakov.moneymanagment.model.BaseIdEntity;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import static com.bugakov.moneymanagment.dao.TransactionHelper.doInTransaction;

public class AbstractDao<T extends BaseIdEntity> {
    private final EntityManager entityManager;
    private final Class<T> clazz;

    public AbstractDao(EntityManager entityManager, Class<T> clazz) {
        this.entityManager = entityManager;
        this.clazz = clazz;
    }

    public synchronized void create(T entity) {
        doInTransaction(entityManager, entity, entityManager::persist);
    }

    public synchronized void update(T entity) {
        doInTransaction(entityManager, entity, entityManager::merge);
    }

    public synchronized void delete(T entity) {
        doInTransaction(entityManager, entity, entityManager::remove);
    }

    public synchronized void delete(Long id) {
        T remove = entityManager.find(clazz, id);
        delete(remove);
    }

    public synchronized List<T> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = cb.createQuery(clazz);
        Root<T> from = criteriaQuery.from(clazz);
        criteriaQuery.select(from);
        synchronized (entityManager) {
            TypedQuery<T> typedQuery = entityManager.createQuery(criteriaQuery);
            return typedQuery.getResultList();
        }
    }

    public synchronized T findById(Long id) {
        return entityManager.find(clazz, id);
    }
}
