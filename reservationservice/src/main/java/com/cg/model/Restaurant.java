package com.cg.model;

public class Restaurant {

	private int restaurantId;
	private String restaurantName;
	private int offer;
	private String restaurantType;
	
	

	public Restaurant(int restaurantId, String restaurantName, int offer, String restaurantType) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.offer = offer;
		this.restaurantType = restaurantType;
	}
	
	public Restaurant()
	{
		
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public int getOffer() {
		return offer;
	}

	public void setOffer(int offer) {
		this.offer = offer;
	}

	public String getRestaurantType() {
		return restaurantType;
	}

	public void setRestaurantType(String restaurantType) {
		this.restaurantType = restaurantType;
	}
}
