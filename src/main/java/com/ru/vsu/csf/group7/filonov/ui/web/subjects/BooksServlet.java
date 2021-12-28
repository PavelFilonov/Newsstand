package com.ru.vsu.csf.group7.filonov.ui.web.subjects;

import com.ru.vsu.csf.group7.filonov.db.TypeSubject;
import com.ru.vsu.csf.group7.filonov.db.model.Book;
import com.ru.vsu.csf.group7.filonov.db.model.Subject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/books"})
public class BooksServlet extends SubjectsServlet {

    @Override
    public TypeSubject getType() {
        return TypeSubject.BOOK;
    }

    @Override
    public String getName() {
        return "Books";
    }

    @Override
    public List<? extends Subject> getInheritors(List<Subject> subjects) {
        List<Book> books = new ArrayList<>();

        for (Subject subject : subjects) {
            books.add((Book) subject);
        }

        return books;
    }

    @Override
    public Subject toSubject(HttpServletRequest request) {
        String title = request.getParameter("title");
        int amount = extractInteger(request.getParameter("amount"));
        String author = request.getParameter("author");
        String publisher = request.getParameter("publisher");
        int numberPage = extractInteger(request.getParameter("number_page"));

        return new Book(title, amount, author, publisher, numberPage);
    }

    @Override
    public String getCanonicalName() {
        return BooksServlet.class.getCanonicalName();
    }
}
