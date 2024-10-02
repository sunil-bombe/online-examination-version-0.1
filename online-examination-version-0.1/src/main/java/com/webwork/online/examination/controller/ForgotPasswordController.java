package com.webwork.online.examination.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.webwork.online.examination.service.SendEmailService;
import com.webwork.online.examination.service.impl.SendEmailServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
