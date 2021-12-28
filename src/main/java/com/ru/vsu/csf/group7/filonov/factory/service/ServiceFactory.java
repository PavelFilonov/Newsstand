package com.ru.vsu.csf.group7.filonov.factory.service;

import com.ru.vsu.csf.group7.filonov.db.TypeSubject;
import com.ru.vsu.csf.group7.filonov.factory.bean.BeanFactory;
import com.ru.vsu.csf.group7.filonov.service.Service;

import java.util.List;
import java.util.Optional;

public class ServiceFactory {

    private static ServiceFactory INSTANCE;

    private final List<Service> services;

    private ServiceFactory() {
        services = BeanFactory.getInstance().getBeans(Service.class);
    }

    public static ServiceFactory getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new ServiceFactory();
        }

        return INSTANCE;
    }

    public Optional<Service> getService(TypeSubject type) {
        return services.stream()
                .filter(service -> service.getType().equals(type))
                .findFirst();
    }

    public Service getService() {
        if (services.size() > 0)
            return services.get(0);

        return null;
    }
}
