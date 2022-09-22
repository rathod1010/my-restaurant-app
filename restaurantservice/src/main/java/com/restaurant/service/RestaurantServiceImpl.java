package com.restaurant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.exception.RestaurantNotFoundException;
import com.restaurant.model.Restaurant;
import com.restaurant.repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;

	@Override
	public Restaurant saveRestaurant(Restaurant restaurant) {

		return restaurantRepository.save(restaurant);
	}

	@Override
	public List<Restaurant> getAllRestaurants() {

		return restaurantRepository.findAll();
	}

	@Override
	public Restaurant getRestaurantById(int restaurantId) {

		Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(restaurantId);

		if (optionalRestaurant.isEmpty()) {
			throw new RestaurantNotFoundException("Restaurant not found with id : " + restaurantId);
		}

		return optionalRestaurant.get();
	}

	@Override
	public Restaurant searchByRestaurantName(String restaurantName) {
		
		Restaurant newRestaurant  = restaurantRepository.findByRestaurantName(restaurantName);
		return newRestaurant;
	}

}
