package com.ru.vsu.csf.group7.filonov.factory.repository;

import com.ru.vsu.csf.group7.filonov.db.Repository;
import com.ru.vsu.csf.group7.filonov.db.model.Subject;
import com.ru.vsu.csf.group7.filonov.db.persistence.JDBCRepository;

public class RepositoryFactory {

    private static RepositoryFactory INSTANCE;

    private Repository<Subject> repository;

    private RepositoryFactory() {
        repository = new JDBCRepository();
    }

    public static RepositoryFactory getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new RepositoryFactory();
        }
        return INSTANCE;
    }

    public Repository<Subject> getRepository() {
        return repository;
    }
}
