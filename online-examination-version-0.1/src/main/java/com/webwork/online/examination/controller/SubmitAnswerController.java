package com.webwork.online.examination.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webwork.online.examination.model.Answer;
import com.webwork.online.examination.model.User;
import com.webwork.online.examination.service.QuestionPaperService;
import com.webwork.online.examination.service.impl.QuestionPaperServiceImpl;

public class SubmitAnswerController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private QuestionPaperService questionPaperService = new QuestionPaperServiceImpl();
	
	private User user = null;

	public void doPost(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession(false);
		if(null!=session) {
			user = (User) session.getAttribute("user");
		}
		
		int userId = user.getUserId();

		int answerCount = questionPaperService.getQuestionCount("Angular");
		System.out.println(answerCount);

		Answer[] answer = new Answer[answerCount];
		for (int i = 0; i < answerCount; i++) {
			answer[i] = new Answer();
			answer[i].setUserId(userId);
			answer[i].setQuestionId(i + 1);
			answer[i].setSubject("Angular");
			answer[i].setAnswer(request.getParameter(Integer.toString(i + 1)));

		}

		if (questionPaperService.saveAnswer(answer, answerCount)) {
			RequestDispatcher rd = request.getRequestDispatcher("user-feedback.jsp");
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
			try {
				response.getWriter().println("Answers Not submitted..!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
