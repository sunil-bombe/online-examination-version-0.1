package com.webwork.online.examination.controller;

import java.io.IOException;

import com.webwork.online.examination.model.User;
import com.webwork.online.examination.service.LoginService;
import com.webwork.online.examination.service.impl.LoginServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private LoginService loginService = new LoginServiceImpl();

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {

		String username = request.getParameter("username");

		String userpwd = request.getParameter("userpwd");

		HttpSession session = request.getSession();

		User user = loginService.userLogin(username, userpwd);
		if (null != user) {
			synchronized (session) {
				if (user.getUserType().contentEquals("Admin")) {
					session.setAttribute("admin", user);

					System.out.println(user.getUserType());
					session.setAttribute("adminId", user.getUserId());
					session.setAttribute("adminName", user.getUsername());
					RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
					try {
						rd.forward(request, response);
					} catch (ServletException | IOException e) {
						e.printStackTrace();
					}

				} else {
					System.out.println(user.getUserType());
					session.setAttribute("user", user);
					RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
					try {
						rd.forward(request, response);
					} catch (ServletException | IOException e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}
}
