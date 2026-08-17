package com.tap.model;

public class Resturant {
	
	private int resturantId;
	private String name;
	private String cuisine;
	private String address;
	private double rating;
	private String imageUrl;
	private int deliveryTime;
	private boolean isActive;
	private int adminUserId;
	
	public Resturant() {
		
	}

	public Resturant(int resturantId, String name, String cuisine, String address, double rating, String imageUrl,
			int deliveryTime, boolean isActive, int adminUserId) {
		super();
		this.resturantId = resturantId;
		this.name = name;
		this.cuisine = cuisine;
		this.address = address;
		this.rating = rating;
		this.imageUrl = imageUrl;
		this.deliveryTime = deliveryTime;
		this.isActive = isActive;
		this.adminUserId = adminUserId;
	}

	public int getResturantId() {
		return resturantId;
	}

	public void setResturantId(int resturantId) {
		this.resturantId = resturantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getAdminUserId() {
		return adminUserId;
	}

	public void setAdminUserId(int adminUserId) {
		this.adminUserId = adminUserId;
	}
	
	
	
	

}
