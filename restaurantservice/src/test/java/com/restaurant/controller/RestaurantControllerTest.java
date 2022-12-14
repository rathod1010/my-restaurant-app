package com.restaurant.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restaurant.model.Restaurant;
import com.restaurant.service.RestaurantService;

@ExtendWith(MockitoExtension.class)
public class RestaurantControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private RestaurantService restaurantService;
	private Restaurant restaurant;
	private List<Restaurant> restaurantList;

	@InjectMocks
	private RestaurantController restaurantController;

	@BeforeEach
	public void setUp() {
		restaurant = new Restaurant(1, "paradise", 35, "veg");
		mockMvc = MockMvcBuilders.standaloneSetup(restaurantController).build();
	}

	@Test
	void saveRestaurantControllerTest() throws Exception {
		when(restaurantService.saveRestaurant(any())).thenReturn(restaurant);
		mockMvc.perform(
				post("/restaurant/save").contentType(MediaType.APPLICATION_JSON).content(asJsonString(restaurant)))
				.andExpect(status().isCreated());
		verify(restaurantService, times(1)).saveRestaurant(any());

	}

	@Test
	void getAllRestaurantsControllerTest() throws Exception {
		when(restaurantService.getAllRestaurants()).thenReturn(restaurantList);
		mockMvc.perform(MockMvcRequestBuilders.get("/restaurant/view/all").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(restaurant))).andDo(MockMvcResultHandlers.print());
		verify(restaurantService, times(1)).getAllRestaurants();

	}

	@Test
	void getRestaurantControllerTest() throws Exception {
		when(restaurantService.getRestaurantById(restaurant.getRestaurantId())).thenReturn(restaurant);
		mockMvc.perform(MockMvcRequestBuilders.get("/restaurant/view/1").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(restaurant))).andDo(MockMvcResultHandlers.print());
		verify(restaurantService, times(1)).getRestaurantById(1);

	}

	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
