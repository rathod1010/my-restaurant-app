package com.cg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cg.model.Reservation;
import com.cg.model.ResponseBooking;
import com.cg.model.Restaurant;
import com.cg.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public ResponseBooking bookTable(int restaurantId, Reservation reservation) {

		Reservation newReservation = reservationRepository.save(reservation);
		newReservation.setRestaurantId(restaurantId);

		Restaurant restauarant = restTemplate.getForObject("http://localhost:8090/restaurant/view/" + restaurantId,
				Restaurant.class);

		ResponseBooking responseBooking = new ResponseBooking();
		responseBooking.setReservation(newReservation);

		responseBooking.setRestaurant(restauarant);

		return responseBooking;
	}

	@Override
	public List<Reservation> getReservationsByUser(int userId) {

		return reservationRepository.findByUserId(userId);
	}

	@Override
	public void deleteReservation(int reservationId) {

		reservationRepository.deleteById(reservationId);

	}

}
