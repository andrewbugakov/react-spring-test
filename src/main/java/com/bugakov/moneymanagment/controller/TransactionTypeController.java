package com.bugakov.moneymanagment.controller;

import com.bugakov.moneymanagment.controller.dto.SimpleDto;
import com.bugakov.moneymanagment.dao.TransactionTypeDao;
import com.bugakov.moneymanagment.model.TransactionType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/api/trtype")
public class TransactionTypeController implements Controller<TransactionType, SimpleDto> {
    private final TransactionTypeDao dao;

    public TransactionTypeController(TransactionTypeDao dao) {
        this.dao = dao;
    }

    @Override
    @RequestMapping
    public ResponseEntity<List<TransactionType>> findAll() {
        return ResponseEntity.ok(dao.findAll());
    }

    @Override
    @RequestMapping(value = "/{id}")
    public ResponseEntity<TransactionType> find(@PathVariable("id") Long id) {
        return ResponseEntity.ok(dao.findById(id));
    }

    @Override
    @RequestMapping(value = "/{id}", method = PUT)
    public ResponseEntity<TransactionType> update(@PathVariable("id") Long id, @RequestBody SimpleDto dto) {
        TransactionType type = dao.findById(id);
        type.setName(dto.getName());
        dao.update(type);
        return ResponseEntity.ok(type);
    }

    @Override
    @RequestMapping(method = POST)
    public ResponseEntity<TransactionType> create(@RequestBody SimpleDto dto) {
        TransactionType type = new TransactionType();
        type.setName(dto.getName());
        dao.create(type);
        return ResponseEntity.ok(type);
    }

    @Override
    @RequestMapping(value = "/{id}", method = DELETE)
    public void delete(@PathVariable("id") Long id) {
        dao.delete(id);
    }

}
