package com.tap.servlet;

import java.io.IOException;



import com.tap.dao.UserDAO;
import com.tap.daoimplementation.UserDAOImpl;
import com.tap.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;




@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private UserDAO userDao;
	
	@Override
	public void init() throws ServletException {
		userDao = new UserDAOImpl();	
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password"); // In a real app, hash and check the password
		
		User loggedInUser = userDao.getUser(email);
		
		if(loggedInUser.getPassword() != null && password.equals(loggedInUser.getPassword())) {
			
			// Create a session and redirect to home page
			HttpSession session = req.getSession();
			session.setAttribute("loggedInUser", loggedInUser);
			resp.sendRedirect("index.jsp");
		}else {
			req.setAttribute("errorMessage", "Invalid username or password");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
	
}