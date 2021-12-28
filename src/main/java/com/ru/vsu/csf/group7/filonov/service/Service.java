package com.ru.vsu.csf.group7.filonov.service;

import com.ru.vsu.csf.group7.filonov.db.Repository;
import com.ru.vsu.csf.group7.filonov.db.TypeSubject;
import com.ru.vsu.csf.group7.filonov.db.model.Subject;
import com.ru.vsu.csf.group7.filonov.exception.NegativeAmountException;
import com.ru.vsu.csf.group7.filonov.factory.repository.RepositoryFactory;

import java.util.List;
import java.util.Optional;

public abstract class Service {
    private final Repository<Subject> repository;

    public Service() {
        repository = RepositoryFactory.getINSTANCE().getRepository();
    }

    public List<Subject> getAll() {
        return repository.selectAll();
    }

    public abstract List<Subject> get();

    public Optional<Subject> get(Long id) {
        return repository.selectById(id);
    }

    public List<Subject> get(String title) {
        return repository.selectByTitle(title);
    }

    public boolean add(Subject item) throws NegativeAmountException {
        if (item.getAmount() < 0)
            throw new NegativeAmountException();

        return repository.insert(item);
    }

    public boolean remove(Long id) {
        return repository.deleteById(id);
    }

    public boolean replace(Long id, Subject item) throws NegativeAmountException {
        if (item.getAmount() < 0)
            throw new NegativeAmountException();

        return repository.updateById(id, item);
    }

    protected Repository<Subject> getRepository() {
        return repository;
    }

    public abstract TypeSubject getType();
}
