package com.ru.vsu.csf.group7.filonov.factory.bean.BeanConfigurator;

import java.util.Set;

public interface BeanConfigurator {

    <T> Set<Class<? extends T>> getClassImplementations(Class<T> tClass);
}
