package com.tap.dao;

import java.util.List;

import com.tap.model.Resturant;

public interface ResturantDAO {
	
	void addResturant(Resturant resturant);
	Resturant getResturant(int resturantId);
	void updateResturant(Resturant resturant);
	void deleteResturant(int resturantId);
	List<Resturant> getAllResturants();

}
