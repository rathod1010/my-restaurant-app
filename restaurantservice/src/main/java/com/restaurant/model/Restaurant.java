package com.restaurant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="restaurant_table")
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="restaurant_id")
	private int restaurantId;
	
	@Column(name="restaurant_name")
	private String restaurantName;
	
	@Column(name="offer")
	private int offer;
	
	@Column(name="type")
	private String restaurantType;
	
	public Restaurant(int restaurantId, String restaurantName, int offer, String restaurantType) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.offer = offer;
		this.restaurantType = restaurantType;
	}


	public Restaurant() {
		
		
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
