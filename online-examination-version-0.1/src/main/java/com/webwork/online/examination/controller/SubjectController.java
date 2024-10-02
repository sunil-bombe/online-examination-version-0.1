package com.webwork.online.examination.controller;

import java.io.IOException;

import com.webwork.online.examination.model.Subject;
import com.webwork.online.examination.service.SubjectService;
import com.webwork.online.examination.service.impl.SubjectServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SubjectController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private final SubjectService subjectService = new SubjectServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String subjectName = request.getParameter("subject");
            int examTime = Integer.parseInt(request.getParameter("examTime"));
            String subjectStatus = request.getParameter("subjectStatus");

            Subject subject = new Subject();
            subject.setSubject(subjectName);
            subject.setExamTime(examTime);
            subject.setSubjectStatus(subjectStatus);

            if (subjectService.setSubject(subject)) {
                response.sendRedirect("subject.jsp");
            } else {
                response.sendRedirect("add-subject.jsp");
            }
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid exam time format.");
        } catch (Exception e) {
            // Log the exception (if using a logger)
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing the request.");
        }
    }
}
