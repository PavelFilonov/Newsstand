package com.ru.vsu.csf.group7.filonov.ui.web.subjects;

import com.ru.vsu.csf.group7.filonov.db.TypeSubject;
import com.ru.vsu.csf.group7.filonov.db.model.Journal;
import com.ru.vsu.csf.group7.filonov.db.model.Subject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/journals"})
public class JournalsServlet extends SubjectsServlet {

    @Override
    public TypeSubject getType() {
        return TypeSubject.JOURNAL;
    }

    @Override
    public String getName() {
        return "Journals";
    }

    @Override
    public List<? extends Subject> getInheritors(List<Subject> subjects) {
        List<Journal> journals = new ArrayList<>();

        for (Subject subject : subjects) {
            journals.add((Journal) subject);
        }

        return journals;
    }

    @Override
    public Subject toSubject(HttpServletRequest request) {
        String title = request.getParameter("title");
        int amount = extractInteger(request.getParameter("amount"));
        int number = extractInteger(request.getParameter("number"));
        LocalDate dateRelease = LocalDate.parse(request.getParameter("date_release"));
        int numberPage = extractInteger(request.getParameter("number_page"));

        return new Journal(title, amount, number, dateRelease, numberPage);
    }

    @Override
    public String getCanonicalName() {
        return JournalsServlet.class.getCanonicalName();
    }
}
