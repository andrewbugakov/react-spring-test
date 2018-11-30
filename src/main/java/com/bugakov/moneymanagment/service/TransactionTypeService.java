package com.bugakov.moneymanagment.service;

import com.bugakov.moneymanagment.dao.TransactionTypeDao;
import com.bugakov.moneymanagment.model.IncomingType;
import com.bugakov.moneymanagment.model.TransactionType;

import java.util.List;
import java.util.Optional;

public class TransactionTypeService implements Service<TransactionType, TransactionTypeService.Dto> {
    private final TransactionTypeDao dao;

    public TransactionTypeService(TransactionTypeDao dao) {
        this.dao = dao;
    }

    @Override
    public List<TransactionType> findAll() {
        return dao.findAll();
    }

    @Override
    public TransactionType find(Long id) {
        return dao.findById(id);
    }

    @Override
    public TransactionType update(Long id, Dto dto) {
        TransactionType type = dao.findById(id);
        dto.getName().ifPresent(type::setName);
        dao.update(type);
        return type;
    }

    @Override
    public TransactionType create(Dto dto) {
        TransactionType type = new TransactionType();
        dto.getName().ifPresent(type::setName);
        dao.create(type);
        return type;
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    static class Dto implements com.bugakov.moneymanagment.service.Dto {
        private Optional<String> name;

        public Optional<String> getName() {
            return name;
        }

        public void setName(Optional<String> name) {
            this.name = name;
        }
    }
}
