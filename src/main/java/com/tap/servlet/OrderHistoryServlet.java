package com.tap.servlet;

import java.io.IOException;
import java.util.List;


import com.tap.dao.OrderDAO;
import com.tap.daoimplementation.OrderDAOImpl;
import com.tap.model.Order;
import com.tap.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/orderHistory")
public class OrderHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderDAO orderDAO;

    @Override
    public void init() {
        orderDAO = new OrderDAOImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loggedInUser");

        if (user != null) {
            List<Order> orderHistory = orderDAO.getAllOrdersByUser(user.getUserId());
            request.setAttribute("orderHistory", orderHistory);
            RequestDispatcher dispatcher = request.getRequestDispatcher("order_history.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("login.jsp"); // Redirect to login if user is not logged in
        }
    }
}
