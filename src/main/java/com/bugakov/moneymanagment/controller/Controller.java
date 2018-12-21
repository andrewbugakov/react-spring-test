package com.bugakov.moneymanagment.controller;

import com.bugakov.moneymanagment.controller.dto.Dto;
import com.bugakov.moneymanagment.model.BaseIdEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Controller<T extends BaseIdEntity, D extends Dto> {
    ResponseEntity<List<T>> findAll();

    ResponseEntity<T> find(Long id);

    ResponseEntity<T> update(Long id, D dto);

    ResponseEntity<T> create(D dto);

    void delete(Long id);
}
