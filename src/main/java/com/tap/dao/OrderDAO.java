package com.tap.dao;

import java.util.List;

import com.tap.model.Order;

public interface OrderDAO {
	
	void addOrder(Order order);
	Order getOrder(int orderId);
	void updateOrder(Order orderId);
	void deleteOrder(int orderId);
	List<Order> getAllOrder(Order order);
	List<Order> getAllOrdersByUser(int userId);

}
