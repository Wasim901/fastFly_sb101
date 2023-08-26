package com.masai.system.DAO;

import com.masai.system.DTO.Booking;
import com.masai.system.DTO.Customer;

public interface CustomerDao {

	public void addCustomer(Customer customer);
	public Customer getCustomerById(int customerId);
	public Customer getCustomerByEmail(String email);
	public void updateCustomer(Customer customer);
	public void deleteCustomerById(int customerId);
	public Booking getBookingById(int bookingId);
	
	
}
