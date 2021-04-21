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
import com.webwork.online.examination.service.LoginService;
import com.webwork.online.examination.service.impl.LoginServiceImpl;

@WebServlet("/Login")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private LoginService loginService = new LoginServiceImpl();

	public void doPost(HttpServletRequest request, HttpServletResponse response) {

		String username = request.getParameter("username").toString();

		String userpwd = request.getParameter("userpwd").toString();

		HttpSession session = request.getSession();

		User user = loginService.userLogin(username, userpwd);
		if (null != user) {
			
			synchronized(session) {
				if (user.getUserType().contentEquals("Admin")) {
					session.setAttribute("admin", user);

					System.out.println(user.getUserType());
					session.setAttribute("adminId", user.getUserId());
					session.setAttribute("adminName", user.getUsername());
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

				} else {
					System.out.println(user.getUserType());
					session.setAttribute("user", user );
//					session.setAttribute("userId", user.getUserId());
//					session.setAttribute("userName", user.getUsername());
					RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
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
			
		} else {

			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
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
