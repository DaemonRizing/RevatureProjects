package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.controller.EmployeeController;


public class EmployeeHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public EmployeeHomeServlet() {
		super();
	
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if(session.isNew()) {
			System.out.println("Ooops");
		}else {
			
			PrintWriter pw = response.getWriter();
			pw.print(EmployeeController.getEmployeeByUsername((String) session.getAttribute("username")));
			
			
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
