package com.bugakov.moneymanagment.dao;

import com.bugakov.moneymanagment.model.User;

import javax.persistence.EntityManager;

public class UserDao extends AbstractDao<User> {
    public UserDao(EntityManager entityManager) {
        super(entityManager, User.class);
    }
}
