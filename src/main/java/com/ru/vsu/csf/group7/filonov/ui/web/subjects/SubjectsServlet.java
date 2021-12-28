package com.ru.vsu.csf.group7.filonov.ui.web.subjects;

import com.ru.vsu.csf.group7.filonov.db.TypeSubject;
import com.ru.vsu.csf.group7.filonov.db.model.Subject;
import com.ru.vsu.csf.group7.filonov.exception.NegativeAmountException;
import com.ru.vsu.csf.group7.filonov.factory.service.ServiceFactory;
import com.ru.vsu.csf.group7.filonov.service.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public abstract class SubjectsServlet extends HttpServlet {

    private Service service;
    private final Logger logger = Logger.getLogger(getCanonicalName());

    @Override
    public void init() throws ServletException {
        super.init();
        Optional<Service> s = ServiceFactory.getINSTANCE().getService(getType());
        if (s.isPresent())
            service = s.get();
        else
            logger.info("Not found services");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<? extends Subject> subjects = castToInheritorsOfSubject(service.get());

        req.setAttribute(getName().toLowerCase(), subjects);

        getServletContext()
                .getRequestDispatcher(String.format("/subjects/%s.jsp", getName().toLowerCase()))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String info = String.format("%s ", getName());

        try {
            service.add(toSubject(req));
            info += "added";
        } catch (NegativeAmountException e) {
            info += "not added";
            logger.info(info + "\nNegativeAmountException: " + e.getMessage());
        }

        req.setAttribute("info", info);

        doGet(req, resp);
    }

    private List<? extends Subject> castToInheritorsOfSubject(List<Subject> subjects) {
        return getInheritors(subjects);
    }

    protected Integer extractInteger(String value) {
        if (value != null) {
            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException e ) {
                logger.info("NumberFormatException: " + e.getMessage());
                return null;
            }
        }
        logger.info("Invalid value");
        return null;
    }
    
    public abstract TypeSubject getType();

    public abstract String getName();

    public abstract List<? extends Subject> getInheritors(List<Subject> subjects);

    public abstract Subject toSubject(HttpServletRequest request);

    public abstract String getCanonicalName();
}
