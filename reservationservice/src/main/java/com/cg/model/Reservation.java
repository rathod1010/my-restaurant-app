package com.cg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservation_table")
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reservation_id")
	private int reservationId;

	@Column(name = "table_no")
	private String bookingNum;

	@Column(name = "date")
	private String date;

	@Column(name = "time")
	private String time;

	@Column(name = "guests")
	private int noOfGuests;

	@Column(name = "restaurant_id")
	private int restaurantId;
	//Restaurant res;

	@Column(name = "user_id")
	private int userId;
    
	

	
	
	public Reservation(int reservationId, String bookingNum, String date, String time, int noOfGuests, int restaurantId,
			int userId) {
		super();
		this.reservationId = reservationId;
		this.bookingNum = bookingNum;
		this.date = date;
		this.time = time;
		this.noOfGuests = noOfGuests;
		this.restaurantId = restaurantId;
		this.userId = userId;
	
	}


	public Reservation() {
		
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	

	public String getBookingNum() {
		return bookingNum;
	}

	public void setBookingNum(String bookingNum) {
		this.bookingNum = bookingNum;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getNoOfGuests() {
		return noOfGuests;
	}

	public void setNoOfGuests(int noOfGuests) {
		this.noOfGuests = noOfGuests;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	

	
	

}
