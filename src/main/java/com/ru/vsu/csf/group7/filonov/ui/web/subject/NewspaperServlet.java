package com.ru.vsu.csf.group7.filonov.ui.web.subject;

import com.ru.vsu.csf.group7.filonov.db.TypeSubject;
import com.ru.vsu.csf.group7.filonov.db.model.Newspaper;
import com.ru.vsu.csf.group7.filonov.db.model.Subject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@WebServlet(urlPatterns = {"/newspaper/*"})
public class NewspaperServlet extends SubjectServlet {

    @Override
    public TypeSubject getType() {
        return TypeSubject.NEWSPAPER;
    }

    @Override
    public String getName() {
        return "Newspaper";
    }

    @Override
    public Subject toSubject(HttpServletRequest request) {
        Long id = extractId(request.getPathInfo());
        String title = request.getParameter("title");
        int amount = extractInteger(request.getParameter("amount"));
        int number = extractInteger(request.getParameter("number"));
        LocalDate dateRelease = LocalDate.parse(request.getParameter("date_release"));

        return new Newspaper(id, title, amount, number, dateRelease);
    }

    @Override
    public String getCanonicalName() {
        return NewspaperServlet.class.getCanonicalName();
    }
}
