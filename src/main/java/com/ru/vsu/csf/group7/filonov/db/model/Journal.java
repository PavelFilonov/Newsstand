package com.ru.vsu.csf.group7.filonov.db.model;

import com.ru.vsu.csf.group7.filonov.db.TypeSubject;

import java.time.LocalDate;

public class Journal extends Subject {

    private int number;
    private LocalDate dateRelease;
    private int numberPage;

    public Journal(Long id, String title, int amount, int number, LocalDate dateRelease, int numberPage) {
        super(id, title, amount, TypeSubject.JOURNAL);
        this.number = number;
        this.dateRelease = dateRelease;
        this.numberPage = numberPage;
    }

    public Journal(String title, int number, int year, int month, int day, int numberPage, int amount) {
        super(TypeSubject.JOURNAL, title, amount);
        this.number = number;
        this.dateRelease = LocalDate.of(year, month, day);
        this.numberPage = numberPage;
    }

    public Journal(String title, int amount, int number, LocalDate dateRelease, int numberPage) {
        super(TypeSubject.JOURNAL, title, amount);
        this.number = number;
        this.dateRelease = dateRelease;
        this.numberPage = numberPage;
    }

    public int getNumber() {
        return number;
    }

    public int getYearRelease() { return dateRelease.getYear(); }

    public int getMonthRelease() { return dateRelease.getMonthValue(); }

    public int getDayRelease() { return dateRelease.getDayOfYear(); }

    public int getNumberPage() {
        return numberPage;
    }

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

        Journal journal = (Journal) obj;

        return getId().equals(journal.getId()) || number == journal.number;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Journal{");
        sb.append("id='").append(getId()).append('\'');
        sb.append(", title='").append(getTitle()).append('\'');
        sb.append(", number=").append(number).append('\'');
        sb.append(", dateRelease=").append(dateRelease).append('\'');
        sb.append(", numberPage=").append(numberPage).append('\'');
        sb.append(", amount=").append(getAmount());
        sb.append('}');
        return sb.toString();
    }
}
