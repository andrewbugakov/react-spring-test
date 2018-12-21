package com.bugakov.moneymanagment.controller;

import com.bugakov.moneymanagment.controller.dto.SimpleDto;
import com.bugakov.moneymanagment.dao.IncomingTypeDao;
import com.bugakov.moneymanagment.model.IncomingType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/api/intypes")
public class IncomingTypeController implements Controller<IncomingType, SimpleDto> {
    private final IncomingTypeDao dao;

    public IncomingTypeController(IncomingTypeDao dao) {
        this.dao = dao;
    }

    @Override
    @RequestMapping
    public ResponseEntity<List<IncomingType>> findAll() {
        return ResponseEntity.ok(dao.findAll());
    }

    @Override
    @RequestMapping(value = "/{id}")
    public ResponseEntity<IncomingType> find(@PathVariable("id") Long id) {
        return ResponseEntity.ok(dao.findById(id));
    }

    @Override
    @RequestMapping(value = "/{id}", method = PUT)
    public ResponseEntity<IncomingType> update(@PathVariable("id") Long id, @RequestBody SimpleDto dto) {
        IncomingType incomingType = dao.findById(id);
        incomingType.setName(dto.getName());
        dao.update(incomingType);
        return ResponseEntity.ok(incomingType);
    }

    @Override
    @RequestMapping(method = POST)
    public ResponseEntity<IncomingType> create(@RequestBody SimpleDto dto) {
        IncomingType incomingType = new IncomingType();
        incomingType.setName(dto.getName());
        dao.create(incomingType);
        return ResponseEntity.ok(incomingType);
    }

    @Override
    @RequestMapping(value = "/{id}", method = DELETE)
    public void delete(@PathVariable("id") Long id) {
        dao.delete(id);
    }

}
