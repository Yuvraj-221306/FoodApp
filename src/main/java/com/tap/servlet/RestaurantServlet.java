package com.tap.servlet;


import java.io.IOException;
import java.util.List;

import com.tap.dao.ResturantDAO;
import com.tap.daoimplementation.ResturantDAOImpl;
import com.tap.model.Resturant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



@WebServlet("/restaurant")
public class RestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	   private ResturantDAO restaurantDao;

	   @Override
	    public void init() {
	        restaurantDao = new ResturantDAOImpl();
	    }

	    @Override
	    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    	
	        List<Resturant> restaurantList = restaurantDao.getAllResturants();
	        System.out.println(restaurantList);
	        
	        HttpSession session = req.getSession();
	        session.setAttribute("restaurantList", restaurantList);
	        System.out.println("working");
	        
	        resp.sendRedirect("restaurant.jsp");
	       
	        
//	        req.setAttribute("restaurantList", restaurantList);
//	        System.out.println("Working");
//	        
//	        RequestDispatcher dispatcher = req.getRequestDispatcher("restaurant.jsp");
//	        dispatcher.include(req, resp);
	    }
	    
	    
	    
//        List<Restaurant> restaurantListSession = (List<Restaurant>) session.getAttribute("restaurantList");
//        System.out.println(restaurantListSession.get(0).getrestaurantId());
//        for (Restaurant restaurant : restaurantListSession) {
//        	System.out.println(restaurant.getrestaurantId());
//		}

	}