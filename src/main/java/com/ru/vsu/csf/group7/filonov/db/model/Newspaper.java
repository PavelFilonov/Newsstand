package com.ru.vsu.csf.group7.filonov.db.model;

import com.ru.vsu.csf.group7.filonov.db.TypeSubject;

import java.time.LocalDate;

public class Newspaper extends Subject {

    private int number;
    private LocalDate dateRelease;

    public Newspaper(Long id, String title, int amount, int number, LocalDate dateRelease) {
        super(id, title, amount, TypeSubject.NEWSPAPER);
        this.number = number;
        this.dateRelease = dateRelease;
    }

    public Newspaper(String title, int number, int year, int month, int day, int amount) {
        super(TypeSubject.NEWSPAPER, title, amount);
        this.number = number;
        this.dateRelease = LocalDate.of(year, month, day);
    }

    public Newspaper(String title, int amount, int number, LocalDate dateRelease) {
        super(TypeSubject.NEWSPAPER, title, amount);
        this.number = number;
        this.dateRelease = dateRelease;
    }

    public int getNumber() {
        return number;
    }

    public int getYearRelease() { return dateRelease.getYear(); }

    public int getMonthRelease() { return dateRelease.getMonthValue(); }

    public int getDayRelease() { return dateRelease.getDayOfYear(); }

    public LocalDate getDateRelease() {
        return dateRelease;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Newspaper newspaper = (Newspaper) obj;

        return getId().equals(newspaper.getId()) || number == newspaper.number;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Newspaper{");
        sb.append("id='").append(getId()).append('\'');
        sb.append(", title='").append(getTitle()).append('\'');
        sb.append(", number=").append(number).append('\'');
        sb.append(", dateRelease=").append(dateRelease).append('\'');
        sb.append(", amount=").append(getAmount());
        sb.append('}');
        return sb.toString();
    }
}
