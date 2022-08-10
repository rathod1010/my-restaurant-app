package com.restaurant.service;

import java.util.List;

import com.restaurant.model.Restaurant;

public interface RestaurantService {
	
	Restaurant saveRestaurant(Restaurant restaurant);
	
	List<Restaurant> getAllRestaurants();
	
	Restaurant getRestaurantById(int restaurantId);

}
