package com.ru.vsu.csf.group7.filonov.factory.bean;

import com.ru.vsu.csf.group7.filonov.factory.bean.BeanConfigurator.BeanConfigurator;
import com.ru.vsu.csf.group7.filonov.factory.bean.BeanConfigurator.JavaBeanConfigurator;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

import static java.util.stream.Collectors.toList;

public class BeanFactory {

    private static BeanFactory INSTANCE;

    private BeanFactory() {
        beanConfigurator = new JavaBeanConfigurator();
    }

    public static BeanFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BeanFactory();
        }
        return INSTANCE;
    }

    private final BeanConfigurator beanConfigurator;

    public <T> T getBean(Class<T> tClass) {
        Class<? extends T> implClass;
        final Set<Class<? extends T>> classImplementations = beanConfigurator.getClassImplementations(tClass);
        if (classImplementations.size() != 1) {
            throw new RuntimeException("Interface has 0 or more than 1 implementation");
        }
        implClass = classImplementations.stream().findFirst().get();
        return initBean(implClass);
    }

    public <T> List<T> getBeans(Class<T> tClass) {
        final Set<Class<? extends T>> classImplementations = beanConfigurator.getClassImplementations(tClass);

        return classImplementations.stream()
                .map(this::initBean)
                .collect(toList());
    }

    private <T> T initBean(Class<T> implClass) {
        try {
            final T bean = implClass.getDeclaredConstructor().newInstance();

            Arrays.stream(bean.getClass().getDeclaredFields())
                    .forEach(field -> {
                        field.setAccessible(true);
                        try {
                            if (Collection.class.isAssignableFrom(field.getType())) {
                                final ParameterizedType type = (ParameterizedType) field.getGenericType();
                                final Type actualTypeArgument = type.getActualTypeArguments()[0];

                                field.set(bean, INSTANCE.getBeans((Class) actualTypeArgument));
                            } else {
                                field.set(bean, INSTANCE.getBean(field.getType()));
                            }
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException("No access to field");
                        }
                    });
            return bean;
        } catch (Exception e) {
            throw new RuntimeException("Exception while bean initialization");
        }
    }
}
