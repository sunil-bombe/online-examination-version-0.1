package com.webwork.online.examination.controller;

import java.io.IOException;


import com.webwork.online.examination.model.User;
import com.webwork.online.examination.service.UserService;
import com.webwork.online.examination.service.impl.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/newUser")
public class AddUserController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user = new User();
	private UserService userService = new UserServiceImpl();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
		user.setUsername(request.getParameter("userName"));
		user.setUserStatus(request.getParameter("userStatus"));
		
	

		if (userService.newUser(user, request.getParameter("userPwd"))) {

				response.sendRedirect("admin.jsp");
		
		} else {
			
				response.sendRedirect("admin-add-user.jsp");
			
		}

	}

}
