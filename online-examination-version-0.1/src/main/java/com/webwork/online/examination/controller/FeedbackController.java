package com.webwork.online.examination.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webwork.online.examination.model.Feedback;
import com.webwork.online.examination.model.User;
import com.webwork.online.examination.service.UserService;
import com.webwork.online.examination.service.impl.UserServiceImpl;

public class FeedbackController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Feedback feedback = new Feedback();

	private UserService userService = new UserServiceImpl();

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("user");

		feedback.setUserName(request.getParameter("userName").toString());

		feedback.setUserEmail(request.getParameter("userEmail").toString());

		feedback.setUserPhone(request.getParameter("userPhone").toString());

		feedback.setUserComment(request.getParameter("userComment").toString());

		feedback.setUserRemark(request.getParameter("userRemark").toString());
		
		feedback.setUserId(user.getUserId());
		
	

		if (userService.saveFeedback(feedback)) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("thank-you.jsp");
			try {
				requestDispatcher.forward(request, response);
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
