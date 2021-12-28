package com.ru.vsu.csf.group7.filonov.ui.web.subject;

import com.ru.vsu.csf.group7.filonov.db.TypeSubject;
import com.ru.vsu.csf.group7.filonov.db.model.Book;
import com.ru.vsu.csf.group7.filonov.db.model.Subject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet(urlPatterns = {"/book/*"})
public class BookServlet extends SubjectServlet {

    @Override
    public TypeSubject getType() {
        return TypeSubject.BOOK;
    }

    @Override
    public String getName() {
        return "Book";
    }

    @Override
    public Subject toSubject(HttpServletRequest request) {
        Long id = extractId(request.getPathInfo());
        String title = request.getParameter("title");
        int amount = extractInteger(request.getParameter("amount"));
        String author = request.getParameter("author");
        String publisher = request.getParameter("publisher");
        int numberPage = extractInteger(request.getParameter("number_page"));

        return new Book(id, title, amount, author, publisher, numberPage);
    }

    @Override
    public String getCanonicalName() {
        return BookServlet.class.getCanonicalName();
    }
}
