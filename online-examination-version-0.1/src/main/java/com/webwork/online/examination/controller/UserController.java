package com.webwork.online.examination.controller;

import java.io.IOException;

import com.webwork.online.examination.model.User;
import com.webwork.online.examination.service.UserService;
import com.webwork.online.examination.service.impl.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UserController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Session has expired. Please log in again.");
            return;
        }

        User sessionUser = (User) session.getAttribute("user");
        if (sessionUser == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User not found. Please log in.");
            return;
        }

        // Getting all properties from the user form
        String fullname = request.getParameter("userName");
        String email = request.getParameter("userEmail");
        String phone = request.getParameter("userPhone");
        String birthDate = request.getParameter("userBirth");
        String college = request.getParameter("userCollege");

        // Set user object
        User user = new User();
        user.setUserId(sessionUser.getUserId());
        user.setUserFullName(fullname);
        user.setUserEmail(email);
        user.setUserPhone(phone);
        user.setUserBirthDate(birthDate);
        user.setUserCollege(college);

        // Call service method
        try {
            if (userService.saveUser(user)) {
                request.getRequestDispatcher("user-instructions.jsp").forward(request, response);
            } else {
                response.getWriter().println("User not saved!");
            }
        } catch (IOException | ServletException e) {
            // Log the exception (if using a logger)
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing your request.");
        }
    }
}
 