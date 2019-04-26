package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


import com.revature.controller.ReimbursementsController;



public class ReimbursementCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Logger log = Logger.getRootLogger();


	public ReimbursementCreateServlet() {
		super();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ReimbursementsController.createNewReimbursement(request);
		request.getRequestDispatcher("/Views/employeehome.html").forward(request, response);
		;
	}

}
