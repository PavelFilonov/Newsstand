package com.ru.vsu.csf.group7.filonov.db.persistence.converter;

import com.ru.vsu.csf.group7.filonov.factory.bean.BeanFactory;

import java.util.List;

public class ConverterFactory {

    private List<Converter> converters;

    private static ConverterFactory instance;

    private ConverterFactory() {
        converters = BeanFactory.getInstance().getBeans(Converter.class);
    }

    public static ConverterFactory getInstance() {
        if (instance == null) {
            instance = new ConverterFactory();
        }
        return instance;
    }

    public Converter getConverter(String type) {
        return converters.stream()
                .filter(converter -> converter.getType().equals(type))
                .findFirst().get();
    }
}
