package com.bugakov.moneymanagment.service;

import com.bugakov.moneymanagment.dao.IncomingDao;
import com.bugakov.moneymanagment.dao.IncomingTypeDao;
import com.bugakov.moneymanagment.model.Incoming;
import com.bugakov.moneymanagment.model.IncomingType;

import java.util.List;
import java.util.Optional;

public class IncomingService implements Service<Incoming, IncomingService.Dto> {
    private final IncomingDao dao;

    public IncomingService(IncomingDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Incoming> findAll() {
        return dao.findAll();
    }

    @Override
    public Incoming find(Long id) {
        return dao.findById(id);
    }

    @Override
    public Incoming update(Long id, Dto dto) {
        Incoming incomingType = dao.findById(id);
        dto.getName().ifPresent(incomingType::setName);
        dao.update(incomingType);
        return incomingType;
    }

    @Override
    public Incoming create(Dto dto) {
        Incoming incomingType = new Incoming();
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
