package com.webwork.online.examination.controller;

import java.io.IOException;

import com.webwork.online.examination.model.Answer;
import com.webwork.online.examination.model.User;
import com.webwork.online.examination.service.QuestionPaperService;
import com.webwork.online.examination.service.impl.QuestionPaperServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SubmitAnswerController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private final QuestionPaperService questionPaperService = new QuestionPaperServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session == null) {
            // Session not found, redirect or handle error
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Session has expired. Please log in again.");
            return;
        }

        User user = (User) session.getAttribute("user");
        if (user == null) {
            // User not found in session, handle accordingly
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User not found. Please log in.");
            return;
        }

        int userId = user.getUserId();
        int answerCount = questionPaperService.getQuestionCount("Angular");
        
        Answer[] answers = new Answer[answerCount];
        for (int i = 0; i < answerCount; i++) {
            answers[i] = new Answer();
            answers[i].setUserId(userId);
            answers[i].setQuestionId(i + 1);
            answers[i].setSubject("Angular");
            answers[i].setAnswer(request.getParameter(Integer.toString(i + 1)));
        }

        try {
            if (questionPaperService.saveAnswer(answers, answerCount)) {
                request.getRequestDispatcher("user-feedback.jsp").forward(request, response);
            } else {
                response.getWriter().println("Answers not submitted. Please try again later.");
            }
        } catch (IOException | ServletException e) {
            // Log the exception (if using a logger)
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing your request.");
        }
    }
}
