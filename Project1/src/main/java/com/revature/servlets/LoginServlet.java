package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.ManagerDao;
import com.revature.dao.ManagerDaoImpl;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginChoice = request.getParameter("loginRadios");
		
		HttpSession session = request.getSession();
		
		String user = null;
		String pass = null;
		
		switch(loginChoice) {
		case "manager" :
			ManagerDao mdi = new ManagerDaoImpl();	
			user = request.getParameter("username");
			pass = request.getParameter("password");

			if (mdi.isMatchPassword(user, pass)) {
				session.setAttribute("username", user);
				response.sendRedirect("Views/managerhome.html");
			} else {
				response.sendRedirect("Views/index.html");
			}
			break;
		case "employee" :
			EmployeeDao edi = new EmployeeDaoImpl();
			user = request.getParameter("username");
			pass = request.getParameter("password");

			if (edi.isMatchPassword(user, pass)) {
				session.setAttribute("username", user);
				response.sendRedirect("Views/employeehome.html");
			} else {
				response.sendRedirect("Views/index.html");
			}
			break;
		default : 
			//request.getRequestDispatcher("/home").forward(request, response);
			System.out.println("OOPS");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
