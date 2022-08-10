package com.restaurant.exception;

@SuppressWarnings("serial")
public class RestaurantNotFoundException extends RuntimeException {
	
	public RestaurantNotFoundException(String message)
	{
		super(message);
	}

}
