package com.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.restaurant.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {
	
	Restaurant findByRestaurantName(String restaurantName);

}
