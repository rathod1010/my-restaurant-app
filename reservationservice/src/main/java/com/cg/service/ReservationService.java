package com.cg.service;

import java.util.List;

import com.cg.model.Reservation;
import com.cg.model.ResponseBooking;

public interface ReservationService {
	
	ResponseBooking bookTable(int restaurantId ,Reservation reservation);
	
	List<Reservation> getReservationsByUser(int userId);
	
	void deleteReservation(int reservationId);
	
	

	

}
