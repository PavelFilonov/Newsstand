package com.ru.vsu.csf.group7.filonov.factory.bean;

import com.ru.vsu.csf.group7.filonov.annotation.Injectable;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class InjectableBeanFactory {

    private static InjectableBeanFactory INSTANCE;

    private InjectableBeanFactory() {
    }

    public static InjectableBeanFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new InjectableBeanFactory();
        }
        return INSTANCE;
    }

    public <T> List<T> initBeans(Class<T> tClass) {
        Reflections reflections = new Reflections(tClass.getPackageName());
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(Injectable.class);
        Set<Class<? extends T>> subTypesOf = reflections.getSubTypesOf(tClass);
        System.out.println(subTypesOf);

        List<T> beans = new ArrayList<>();

        for (Class<?> c : classes) {
//            Injectable injectable = c.getAnnotation(Injectable.class);
//            if (injectable.getTypeClass().equals(type)) {
            try {
                beans.add((T) c.getDeclaredConstructor().newInstance());
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
//            }
        }

        return beans;
    }
}
