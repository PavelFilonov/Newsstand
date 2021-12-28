package com.ru.vsu.csf.group7.filonov.ui.web.subject;

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
import java.util.Optional;
import java.util.logging.Logger;

public abstract class SubjectServlet extends HttpServlet {

    private Service service;
    private final Logger logger = Logger.getLogger(getCanonicalName());

    @Override
    public void init() throws ServletException {
        super.init();
        Optional<Service> s = ServiceFactory.getINSTANCE().getService(getType());
        if (s.isPresent())
            service = s.get();
        else
            logger.info("Not found service for " + getName());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = extractId(req.getPathInfo());

        if (id == null) {
            logger.info("Invalid id");
            resp.sendRedirect("/index");
        }

        Optional<Subject> subject = service.get(id);

        if (subject.isEmpty()) {
            logger.info("Subject not found");
            resp.sendRedirect("/index");
        }

        req.setAttribute(getName().toLowerCase(), subject.get());

        getServletContext()
                .getRequestDispatcher(String.format("/subject/%s.jsp", getName().toLowerCase()))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = extractId(req.getPathInfo());
        String info = String.format("%s ", getName());
        switch (req.getParameter("submit")) {
            case "update":
                Subject subject = toSubject(req);

                try {
                    if (!service.replace(id, subject))
                        info += "not ";
                } catch (NegativeAmountException e) {
                    logger.info("NegativeAmountException: " + e.getMessage());
                }
                info += "updated";
                break;
            case "delete":
                if (service.remove(id)) {
                    info += "deleted";
                    req.setAttribute("info", info);
                    resp.sendRedirect(String.format("/%s", getName().toLowerCase() + "s"));
                }
                info += "not deleted";
                break;
            default:
                logger.info("Invalid command");
                resp.sendRedirect("/index");
                break;
        }

        req.setAttribute("info", info);

        doGet(req, resp);
    }

    protected Long extractId(String path) {
        if (path != null) {
            try {
                return Long.valueOf(path.split("/")[1].split("\\?")[0]);
            } catch (NumberFormatException e ) {
                logger.info("NumberFormatException: " + e.getMessage());
                return null;
            }
        }
        logger.info("Invalid path");
        return null;
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

    public abstract Subject toSubject(HttpServletRequest request);

    public abstract String getCanonicalName();
}
