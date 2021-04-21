package com.webwork.online.examination.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webwork.online.examination.service.SendEmailService;
import com.webwork.online.examination.service.impl.SendEmailServiceImpl;
@WebServlet("/ForgotPassword")
public class ForgotPasswordController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private SendEmailService  sendEmailService = new SendEmailServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//.send("sunilbombe456@gmail.com","8390032965","sunilbombe456@gmail.com","hello javatpoint","How r u?");
		
		out.print("forgot password");
	}

}
