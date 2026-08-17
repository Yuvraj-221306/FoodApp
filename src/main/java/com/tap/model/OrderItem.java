package com.tap.model;

public class OrderItem {
	
	private int OrderItemId;
	private int orderId;
	private int menuId;
	private int quality;
	private double itemTotal;
	private Menu menuItem;
	
	public OrderItem() {
		
	}

	public OrderItem(int orderItemId, int orderId, int menuId, int quality, double itemTotal) {
		super();
		OrderItemId = orderItemId;
		this.orderId = orderId;
		this.menuId = menuId;
		this.quality = quality;
		this.itemTotal = itemTotal;
	}

	public int getOrderItemId() {
		return OrderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		OrderItemId = orderItemId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public double getItemTotal() {
		return itemTotal;
	}

	public void setItemTotal(double itemTotal) {
		this.itemTotal = itemTotal;
	}

	public Menu getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(Menu menuItem) {
		this.menuItem = menuItem;
	}
	
	
	

}
