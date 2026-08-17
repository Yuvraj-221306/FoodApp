package com.tap.daoimplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.tap.dao.ResturantDAO;
import com.tap.model.Resturant;
import com.tap.utility.DBConnection;

public class ResturantDAOImpl implements ResturantDAO{
	
	Scanner scan = new Scanner(System.in);
	
	Connection connection = null;
	
	String insertQuery = "INSERT INTO `restaurant` (`restaurant_name`,`cousine_type`,`delivery_time`,`address`,`rating`,`is_active`) VALUES (?,?,?,?,?,?)";
	String retreiveQuery = "SELECT * FROM `restaurant` WHERE `restaurant_id` = ?";
	String updateQuery = "UPDATE `restaurant` SET `restaurant_name` = ? , `cousine_type` = ? , `delivery_time` = ? , `address` = ? ,`rating` = ? ,`is_active`= ? WHERE `restaurant_id` = ?";
	String deleteQuery = "DELETE FROM `restaurant` WHERE `restaurant_id` = ?";
	String selectQuery = "Select * FROM `restaurant`";
	PreparedStatement statement = null;
	Statement statement2 = null;
    ResultSet res = null;	
    
    public ResturantDAOImpl() {
    	try {
			connection = DBConnection.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addResturant(Resturant resturant) {
		try {
			statement = connection.prepareStatement(insertQuery);
			statement.setString(1, resturant.getName());
			statement.setString(2, resturant.getCuisine());
			statement.setInt(3, resturant.getDeliveryTime());
			statement.setString(4, resturant.getAddress());
			statement.setDouble(5, resturant.getRating());
			statement.setBoolean(6, resturant.isActive());
			System.out.println("row affected: " + statement.executeUpdate());
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	public Resturant getResturant(int resturantId) {
		Resturant restaurant = null;
		try {
			statement = connection.prepareStatement(retreiveQuery);
			statement.setInt(1,	resturantId);
			ResultSet res = statement.executeQuery();
			
			if(res.next()) {
				
				restaurant = extractUserFromResultSet(res);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return restaurant;		
	}
	
	private Resturant extractUserFromResultSet(ResultSet res) throws SQLException{
		 Resturant restaurant = new Resturant();
		 restaurant.setResturantId(res.getInt("restaurant_id"));
		 restaurant.setName(res.getString("restaurant_name"));
		 restaurant.setCuisine(res.getString("cousine_type"));
		 restaurant.setDeliveryTime(res.getInt("delivery_time"));
		 restaurant.setAddress(res.getString("address"));
		 restaurant.setRating(res.getDouble("rating"));
		 restaurant.setActive(res.getBoolean("is_active"));
		 return restaurant;
	}

	@Override
	public void updateResturant(Resturant resturant){
		try {
			statement = connection.prepareStatement(updateQuery);
			statement.setString(1, resturant.getName());
			statement.setString(2, resturant.getCuisine());
			statement.setInt(3, resturant.getDeliveryTime());
			statement.setString(4, resturant.getAddress());
			statement.setDouble(5, resturant.getRating());
			statement.setBoolean(6, resturant.isActive());
			statement.setInt(7, resturant.getResturantId());

			System.out.println("row affected: " + statement.executeUpdate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteResturant(int resturantId) {
		try {
			statement = connection.prepareStatement(deleteQuery);
			statement.setInt(1,resturantId);
			System.out.println("row affected: " + statement.executeUpdate());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Resturant> getAllResturants() {
		List<Resturant> list = new ArrayList<>();
		        try {
		            statement2 = connection.createStatement();
		            res = statement2.executeQuery(selectQuery);
		            while (res.next()) {
		            	Resturant restaurant = extractUserFromResultSet(res);
                list.add(restaurant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
		return list;
	}
}