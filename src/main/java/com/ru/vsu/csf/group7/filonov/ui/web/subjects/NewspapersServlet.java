package com.ru.vsu.csf.group7.filonov.ui.web.subjects;

import com.ru.vsu.csf.group7.filonov.db.TypeSubject;
import com.ru.vsu.csf.group7.filonov.db.model.Newspaper;
import com.ru.vsu.csf.group7.filonov.db.model.Subject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/newspapers"})
public class NewspapersServlet extends SubjectsServlet {

    @Override
    public TypeSubject getType() {
        return TypeSubject.NEWSPAPER;
    }

    @Override
    public String getName() {
        return "Newspapers";
    }

    @Override
    public List<? extends Subject> getInheritors(List<Subject> subjects) {
        List<Newspaper> newspapers = new ArrayList<>();

        for (Subject subject : subjects) {
            newspapers.add((Newspaper) subject);
        }

        return newspapers;
    }

    @Override
    public Subject toSubject(HttpServletRequest request) {
        String title = request.getParameter("title");
        int amount = extractInteger(request.getParameter("amount"));
        int number = extractInteger(request.getParameter("number"));
        LocalDate dateRelease = LocalDate.parse(request.getParameter("date_release"));

        return new Newspaper(title, amount, number, dateRelease);
    }

    @Override
    public String getCanonicalName() {
        return NewspapersServlet.class.getCanonicalName();
    }
}
