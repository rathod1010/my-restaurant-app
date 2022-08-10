package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
	
	List<Reservation> findByUserId(int userId);

}
