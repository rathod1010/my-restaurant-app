package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.model.Reservation;
import com.cg.model.ResponseBooking;
import com.cg.model.Restaurant;
import com.cg.service.ReservationService;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;

	@PostMapping("book/table/{restaurantId}")
	public ResponseEntity<ResponseBooking> reserveTable(@PathVariable("restaurantId") int restaurantId,
			@RequestBody Reservation reservation) {

		ResponseBooking newReservation = reservationService.bookTable(restaurantId, reservation);

		return new ResponseEntity<>(newReservation, HttpStatus.CREATED);

	}

	@GetMapping("/view/all/{userId}")
	public List<Reservation> fetchAllReservationByUser(@PathVariable("userId") int userId) {
		return reservationService.getReservationsByUser(userId);
	}
	
	@DeleteMapping("/delete/booking")
	public ResponseEntity<String> cancelBooking(int reservationId) {
		reservationService.deleteReservation(reservationId);
		return new ResponseEntity<>("Booking cancelled successfully",HttpStatus.OK);
	}
	

}