package com.webwork.online.examination.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webwork.online.examination.model.User;
import com.webwork.online.examination.service.UserService;
import com.webwork.online.examination.service.impl.UserServiceImpl;
@WebServlet("/SaveUser")
public class UserController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private UserService userService = new UserServiceImpl();
	
	private User user = null;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		
		user = (User) session.getAttribute("user");
		// getting all properties from user Form
		int userId = user.getUserId();
		String fullname = request.getParameter("userName").toString();
		String email = request.getParameter("userEmail").toString();
		String phone = request.getParameter("userPhone").toString();
		String birthDate = request.getParameter("userBirth");
		String college = request.getParameter("userCollege").toString();

		// Set user Object

		User user = new User();

		user.setUserId(userId);
		user.setUserFullName(fullname);
		user.setUserEmail(email);
		user.setUserPhone(phone);
		user.setUserBirthDate(birthDate);
		user.setUserCollege(college);

//		creating service object
//		and call service method

		if (userService.saveUser(user)) {

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("user-instructions.jsp");
			try {
				requestDispatcher.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {

			try {
				response.getWriter().println("user not saved..!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
