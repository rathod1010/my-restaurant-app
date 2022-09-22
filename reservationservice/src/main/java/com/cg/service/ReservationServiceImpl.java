package com.cg.service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;


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
	public ResponseBooking bookTable(Reservation reservation) {

		LocalDateTime dateTime = LocalDateTime.now();
		String orderNum = "ORD"+dateTime.getYear()+dateTime.getMonthValue()+dateTime.getHour()+dateTime.getMinute()+dateTime.getSecond();
		
		reservation.setBookingNum(orderNum);
		Reservation newReservation = reservationRepository.save(reservation);
		
//
//	 dateTime = LocalDateTime.now();	LocalDateTime
//		String orderNum = "ORD"+dateTime.getYear()+dateTime.getMonthValue()+dateTime.getHour()+dateTime.getMinute()+dateTime.getSecond();

		Restaurant restauarant = restTemplate.getForObject("http://localhost:8090/restaurant/view/" + newReservation.getRestaurantId(),
				Restaurant.class);
//	String restName = restauarant.getRestaurantName();
//	newReservation.setRestaurantName(restName);
		ResponseBooking responseBooking = new ResponseBooking();
		responseBooking.setReservation(newReservation);

		responseBooking.setRestaurant(restauarant);

		return responseBooking;
	}

	@Override
	public List<Reservation> getReservationsByUser(int userId) {

		List<Reservation> reservations = reservationRepository.findByUserId(userId);
		Collections.reverse(reservations);
		return reservations;
	}
	
	

	@Override
	public void deleteReservation(int reservationId) {

		reservationRepository.deleteById(reservationId);

	}

	
	


}
