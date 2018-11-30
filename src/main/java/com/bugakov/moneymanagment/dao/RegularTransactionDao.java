package com.bugakov.moneymanagment.dao;

import com.bugakov.moneymanagment.model.RegularTransaction;

import javax.persistence.EntityManager;

public class RegularTransactionDao extends AbstractDao<RegularTransaction> {
    public RegularTransactionDao(EntityManager entityManager) {
        super(entityManager, RegularTransaction.class);
    }
}
