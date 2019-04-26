package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.controller.EmployeeController;


public class EmployeeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EmployeeUpdateServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeeController.updateEmployee(request, session.getAttribute("username").toString());
		request.getRequestDispatcher("/Views/employeehome.html").forward(request, response);
		
	}

}
