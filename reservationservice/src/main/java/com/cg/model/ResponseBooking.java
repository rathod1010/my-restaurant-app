package com.cg.model;



public class ResponseBooking {


	private Reservation reservation;

	private Restaurant restaurant;
	
	

	public ResponseBooking(Reservation reservation, Restaurant restaurant) {
		super();
		this.reservation = reservation;
		this.restaurant = restaurant;
	}
	
	public ResponseBooking()
	{
		
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

}
