package com.webwork.online.examination.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webwork.online.examination.service.UserService;
import com.webwork.online.examination.service.impl.UserServiceImpl;


public class UserDeleteController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int userId;
	private UserService userService;

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		userService = new UserServiceImpl();
		userId = Integer.parseInt(request.getParameter("userId"));
		if(userService.deleteUser(userId)) {
			RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}
