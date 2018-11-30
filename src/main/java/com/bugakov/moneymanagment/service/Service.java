package com.bugakov.moneymanagment.service;

import com.bugakov.moneymanagment.model.BaseIdEntity;

import java.util.List;

public interface Service<T extends BaseIdEntity, D extends Dto> {
    List<T> findAll();

    T find(Long id);

    T update(Long id, D dto);

    T create(D dto);

    void delete(Long id);
}
