package com.ru.vsu.csf.group7.filonov.db;

import java.util.concurrent.atomic.AtomicLong;

public class AutoIncrementKey {
    private static AtomicLong al = new AtomicLong(1);

    public static Long getId() {
        return al.getAndIncrement();
    }
}
