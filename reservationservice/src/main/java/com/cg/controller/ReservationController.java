package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.client.AuthClient;
import com.cg.model.AuthRequest;
import com.cg.model.LoginResponse;
import com.cg.model.Reservation;
import com.cg.model.ResponseBooking;
import com.cg.model.Restaurant;
import com.cg.service.ReservationService;

@RestController
@RequestMapping("/reservation")
@CrossOrigin(origins = "http://localhost:3000/")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private AuthClient authClient;
	

	@PostMapping("/book/table")
	public ResponseEntity<ResponseBooking> reserveTable(@RequestBody Reservation reservation, @RequestHeader(value="Authorization") String token) {
		
		if (!authClient.getValidity(token).getValid()) {

			return new ResponseEntity("Token is either expired or invalid...", HttpStatus.FORBIDDEN);
		}

		ResponseBooking newReservation = reservationService.bookTable(reservation);
		return new ResponseEntity<>(newReservation, HttpStatus.CREATED);

	}
	

	

	@GetMapping("/view/all/{userId}")
	public ResponseEntity<List<Reservation>> fetchAllReservationByUser(@PathVariable("userId") int userId,@RequestHeader(value="Authorization") String token) {
		
		if (!authClient.getValidity(token).getValid()) {

			return new ResponseEntity("Token is either expired or invalid...", HttpStatus.FORBIDDEN);
		}

		List<Reservation> resList = reservationService.getReservationsByUser(userId);
		
		return new ResponseEntity<>(resList, HttpStatus.OK);
	}

	@DeleteMapping("/delete/booking")
	public ResponseEntity<String> cancelBooking(int reservationId) {
		reservationService.deleteReservation(reservationId);
		return new ResponseEntity<>("Booking cancelled successfully", HttpStatus.OK);
	}

}
