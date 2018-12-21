package com.bugakov.moneymanagment.dao;

import com.bugakov.moneymanagment.model.BaseIdEntity;

import javax.persistence.EntityManager;
import java.util.function.Consumer;

class TransactionHelper {

    static <T extends BaseIdEntity> void doInTransaction(
            EntityManager entityManager,
            T entity,
            Consumer<T> consumer
    ) {
        startTransaction(entityManager);
        try {
            consumer.accept(entity);
            commitTransaction(entityManager);
        } catch (Exception e) {
            rollbackTransaction(entityManager);
        }

    }

    private static void startTransaction(EntityManager entityManager) {
        if (!activeTransactionExist(entityManager)) {
            entityManager.getTransaction().begin();
        }
    }

    private static boolean activeTransactionExist(EntityManager entityManager) {
        return entityManager.getTransaction().isActive();
    }

    private static void commitTransaction(EntityManager entityManager) {
        entityManager.getTransaction().commit();
    }

    private static void rollbackTransaction(EntityManager entityManager) {
        if (activeTransactionExist(entityManager)) {
            entityManager.getTransaction().rollback();
        }
    }

}
