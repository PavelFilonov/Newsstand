package com.ru.vsu.csf.group7.filonov.db.model;

import com.ru.vsu.csf.group7.filonov.db.TypeSubject;

public class Book extends Subject {

    private String author;
    private String publisher;
    private int numberPage;


    public Book(Long id, String title, int amount, String author, String publisher, int numberPage) {
        super(id, title, amount, TypeSubject.BOOK);
        this.author = author;
        this.publisher = publisher;
        this.numberPage = numberPage;
    }

    public Book(String title, int amount, String author, String publisher, int numberPage) {
        super(TypeSubject.BOOK, title, amount);
        this.author = author;
        this.publisher = publisher;
        this.numberPage = numberPage;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getNumberPage() {
        return numberPage;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Book book = (Book) obj;

        return getId().equals(book.getId()) || this.getTitle().equals(book.getTitle()) && author.equals(book.author);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("id='").append(getId()).append('\'');
        sb.append(", title='").append(getTitle()).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append(", publisher='").append(publisher).append('\'');
        sb.append(", numberPage=").append(numberPage).append('\'');
        sb.append(", amount=").append(getAmount());
        sb.append('}');
        return sb.toString();
    }
}
