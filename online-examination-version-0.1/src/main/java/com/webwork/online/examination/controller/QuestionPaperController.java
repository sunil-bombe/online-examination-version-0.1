package com.webwork.online.examination.controller;

import java.io.IOException;
import java.util.List;

import com.webwork.online.examination.model.QuestionPaper;
import com.webwork.online.examination.service.QuestionPaperService;
import com.webwork.online.examination.service.impl.QuestionPaperServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class QuestionPaperController extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    
    private final QuestionPaperService questionPaperService = new QuestionPaperServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String subject = request.getParameter("subject");
        String page = request.getParameter("page");

        // Validate input parameters to avoid unnecessary calls
        if (subject != null && page != null) {
            List<QuestionPaper> questionPapers = questionPaperService.getQuestionPaper(subject);
            if (questionPapers != null && !questionPapers.isEmpty()) {
                request.setAttribute("questionPaper", questionPapers);
                request.setAttribute("subject", subject);
                RequestDispatcher rd = request.getRequestDispatcher(page);
                rd.forward(request, response);
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "No question papers found.");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid request parameters.");
        }
    }
}
