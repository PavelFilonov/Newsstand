package com.ru.vsu.csf.group7.filonov.ui.web.subject;

import com.ru.vsu.csf.group7.filonov.db.TypeSubject;
import com.ru.vsu.csf.group7.filonov.db.model.Journal;
import com.ru.vsu.csf.group7.filonov.db.model.Subject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@WebServlet(urlPatterns = {"/journal/*"})
public class JournalServlet extends SubjectServlet {

    @Override
    public TypeSubject getType() {
        return TypeSubject.JOURNAL;
    }

    @Override
    public String getName() {
        return "Journal";
    }

    @Override
    public Subject toSubject(HttpServletRequest request) {
        Long id = extractId(request.getPathInfo());
        String title = request.getParameter("title");
        int amount = extractInteger(request.getParameter("amount"));
        int number = extractInteger(request.getParameter("number"));
        LocalDate dateRelease = LocalDate.parse(request.getParameter("date_release"));
        int numberPage = extractInteger(request.getParameter("number_page"));

        return new Journal(id, title, amount, number, dateRelease, numberPage);
    }

    @Override
    public String getCanonicalName() {
        return JournalServlet.class.getCanonicalName();
    }
}
