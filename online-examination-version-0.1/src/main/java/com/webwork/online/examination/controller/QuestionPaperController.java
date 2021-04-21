package com.webwork.online.examination.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webwork.online.examination.model.QuestionPaper;
import com.webwork.online.examination.service.QuestionPaperService;
import com.webwork.online.examination.service.impl.QuestionPaperServiceImpl;

@WebServlet("/QuestionPaper")
public class QuestionPaperController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private QuestionPaperService questionPaperService = new QuestionPaperServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
		String subject = request.getParameter("subject");
		String page = request.getParameter("page");
		List<QuestionPaper> questionPaper = questionPaperService.getQuestionPaper(subject);
		if(null!= questionPaper) {
			request.setAttribute("questionPaper", questionPaper);
			request.setAttribute("subject", subject);
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}
		
	}

}
