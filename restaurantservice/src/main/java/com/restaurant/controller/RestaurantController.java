package com.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.model.Restaurant;
import com.restaurant.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin(origins = "http://localhost:3000/")
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;

	@PostMapping("/save")
	public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant) {

		Restaurant newRestaurant = restaurantService.saveRestaurant(restaurant);

		return new ResponseEntity<>(newRestaurant, HttpStatus.CREATED);
	}

	@GetMapping("/view/all")
	public List<Restaurant> fetchAllRestaurants() {

		return restaurantService.getAllRestaurants();
	}

	@GetMapping("/view/{restaurantId}")
	public ResponseEntity<Restaurant> fetchRestaurantById(@PathVariable("restaurantId") int restaurantId) {

		Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);

		return new ResponseEntity<>(restaurant, HttpStatus.OK);
	}
}
