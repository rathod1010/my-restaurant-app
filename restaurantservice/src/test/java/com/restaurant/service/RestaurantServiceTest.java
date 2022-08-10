package com.restaurant.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.restaurant.exception.RestaurantNotFoundException;
import com.restaurant.model.Restaurant;
import com.restaurant.repository.RestaurantRepository;

@SpringBootTest
class RestaurantServiceTest {

	@InjectMocks
	private RestaurantService restaurantService = new RestaurantServiceImpl();

	@Mock
	private RestaurantRepository restaurantRepository;

	@Test
	void testGetRestaurant() {

		Restaurant restaurant = new Restaurant(1, "bawarchi",20,"veg");

		Optional<Restaurant> optionalRestaurant = Optional.of(restaurant);

		when(restaurantRepository.findById(1)).thenReturn(optionalRestaurant);

		Restaurant myRestaurant = restaurantService.getRestaurantById(1);

		assertEquals("bawarchi", myRestaurant.getRestaurantName());
	}
	


	@Test
	void testGetBookByIdWithException() {

		when(restaurantRepository.findById(1)).thenThrow(RestaurantNotFoundException.class);

		assertThrows(RestaurantNotFoundException.class, () -> restaurantService.getRestaurantById(0));
	}

	@Test
	void testSaveRestaurant() {


		Restaurant restaurant = new Restaurant(2, "mehfil",30,"non-veg");

		when(restaurantRepository.save(restaurant)).thenReturn(restaurant);

		Restaurant newRestaurant = restaurantService.saveRestaurant(restaurant);

		assertEquals("mehfil", newRestaurant.getRestaurantName());

		verify(restaurantRepository, times(1)).save(restaurant); // useful for testing void methods

	}
	
	
	

}