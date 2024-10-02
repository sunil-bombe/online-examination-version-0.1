package com.webwork.online.examination.controller;

import java.io.IOException;

import com.webwork.online.examination.model.Feedback;
import com.webwork.online.examination.model.User;
import com.webwork.online.examination.service.UserService;
import com.webwork.online.examination.service.impl.UserServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class FeedbackController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private Feedback feedback = new Feedback();
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        feedback.setUserName(request.getParameter("userName"));
        feedback.setUserEmail(request.getParameter("userEmail"));
        feedback.setUserPhone(request.getParameter("userPhone"));
        feedback.setUserComment(request.getParameter("userComment"));
        feedback.setUserRemark(request.getParameter("userRemark"));
        feedback.setUserId(user.getUserId());

        if (userService.saveFeedback(feedback)) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("thank-you.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
