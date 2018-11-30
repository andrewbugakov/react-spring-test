package com.bugakov.moneymanagment.service;

import com.bugakov.moneymanagment.dao.IncomingTypeDao;
import com.bugakov.moneymanagment.model.IncomingType;

import java.util.List;
import java.util.Optional;

public class IncomingTypeService implements Service<IncomingType, IncomingTypeService.Dto> {
    private final IncomingTypeDao dao;

    public IncomingTypeService(IncomingTypeDao dao) {
        this.dao = dao;
    }

    @Override
    public List<IncomingType> findAll() {
        return dao.findAll();
    }

    @Override
    public IncomingType find(Long id) {
        return dao.findById(id);
    }

    @Override
    public IncomingType update(Long id, Dto dto) {
        IncomingType incomingType = dao.findById(id);
        dto.getName().ifPresent(incomingType::setName);
        dao.update(incomingType);
        return incomingType;
    }

    @Override
    public IncomingType create(Dto dto) {
        IncomingType incomingType = new IncomingType();
        dto.getName().ifPresent(incomingType::setName);
        dao.create(incomingType);
        return incomingType;
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
