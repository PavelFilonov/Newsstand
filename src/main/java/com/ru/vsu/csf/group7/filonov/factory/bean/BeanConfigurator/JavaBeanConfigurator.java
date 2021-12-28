package com.ru.vsu.csf.group7.filonov.factory.bean.BeanConfigurator;

import static java.util.stream.Collectors.toSet;

import java.util.Set;

import com.ru.vsu.csf.group7.filonov.annotation.Injectable;
import org.reflections.Reflections;

public class JavaBeanConfigurator implements BeanConfigurator {

    @Override
    public <T> Set<Class<? extends T>> getClassImplementations(Class<T> tClass) {
        Reflections scanner = new Reflections(tClass.getPackageName());
        final Set<Class<? extends T>> implementations = scanner.getSubTypesOf(tClass).stream()
            .filter(classImpl -> classImpl.isAnnotationPresent(Injectable.class))
            .collect(toSet());
        return implementations;
    }
}
