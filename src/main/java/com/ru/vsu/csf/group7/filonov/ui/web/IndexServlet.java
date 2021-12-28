package com.ru.vsu.csf.group7.filonov.ui.web;

import com.ru.vsu.csf.group7.filonov.db.model.Subject;
import com.ru.vsu.csf.group7.filonov.factory.service.ServiceFactory;
import com.ru.vsu.csf.group7.filonov.service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet(urlPatterns = {"/index"})
public class IndexServlet extends HttpServlet {

    private Service service;

    @Override
    public void init() throws ServletException {
        super.init();
        service = ServiceFactory.getINSTANCE().getService();
        if (service == null)
            System.out.println("To error");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Subject> subjects;

        switch (req.getParameter("search_button")) {
            case "by_id":
                subjects = new ArrayList<>();
                Optional<Subject> subject = service.get(Long.valueOf(req.getParameter("input_id")));
                subject.ifPresent(subjects::add);
                break;
            case "by_title":
                subjects = service.get(req.getParameter("input_title"));
                break;
            default:
                subjects = service.getAll();
                break;
        }

        req.setAttribute("subjects", subjects);

        getServletContext()
                .getRequestDispatcher("/index.jsp")
                .forward(req, resp);
    }
}
