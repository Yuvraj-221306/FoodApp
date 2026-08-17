package com.tap.servlet;

import java.io.IOException;
import java.util.List;

import com.tap.dao.MenuDAO;
import com.tap.daoimplementation.MenuDAOImpl;
import com.tap.model.Menu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    MenuDAO menuDAO;
    @Override
    public void init() throws ServletException {
    	menuDAO = new MenuDAOImpl();
    }

    @SuppressWarnings("unused")
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	
    	HttpSession session = request.getSession();
    	Integer restaurantId= Integer.parseInt(request.getParameter("restaurantId"));

    	System.out.println("in menu " + restaurantId);
        
        if (restaurantId != null) {
            try {
                int resId = restaurantId;
                List<Menu> menuList = menuDAO.getAllMenusByResturant(resId);
                System.out.println("Retrieved menuList: " + menuList); // Debug statement
                request.setAttribute("menuList", menuList);
            } catch (NumberFormatException e) {
                System.err.println("Invalid restaurantID: " + restaurantId);
                e.printStackTrace();
            } catch (Exception e) {
                System.err.println("Error retrieving menu list: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.err.println("restaurantID is null");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("menu.jsp");
        dispatcher.forward(request, response);
    }

}