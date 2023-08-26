package com.masai.system.DAO;

import com.masai.system.DTO.Booking;

public interface BookingDao {
	
	
	public void addBooking(Booking booking);
	public Booking getBookingById(int bookingId);
	public void updateBooking(Booking booking);
	public void deleteBookingById(int bookingId);
	
	
}
