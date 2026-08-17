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




@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserDAO userDAOImpl;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		userDAOImpl = new UserDAOImpl();
		
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String confirmPassword = req.getParameter("confirmPassword");
		String password = req.getParameter("password");
		String address = req.getParameter("address");
		String role = req.getParameter("role");
		
		if(password.equals(confirmPassword)) {
			
			int x = userDAOImpl.addUser(new User(username, password, email, address, role));
			
			if(x != 0) {
				resp.sendRedirect("login.jsp");
			}else {
				resp.sendRedirect("signupUnsucessful.jsp");
			}
		}else {
			resp.sendRedirect("passwordError.jsp");
		}
		
	}
}