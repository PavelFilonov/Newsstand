package com.ru.vsu.csf.group7.filonov.db.model;

import com.ru.vsu.csf.group7.filonov.db.AutoIncrementKey;
import com.ru.vsu.csf.group7.filonov.db.TypeSubject;

import java.util.Objects;

public abstract class Subject {

    private Long id;
    private String title;
    private int amount;
    private TypeSubject type;

    public Subject(TypeSubject type, String title, int amount) {
        this.type = type;
        this.title = title;
        this.amount = amount;
    }

    public Subject(Long id, String title, int amount, TypeSubject type) {
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.type = type;
    }

    public abstract boolean equals(Object obj);

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setId() {
        id = AutoIncrementKey.getId();
    }

    public TypeSubject getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public int getAmount() {
        return amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setType(TypeSubject type) {
        this.type = type;
    }
}
