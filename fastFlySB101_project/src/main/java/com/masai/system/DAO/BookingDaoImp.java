package com.masai.system.DAO;

import com.masai.system.DTO.Booking;
import com.masai.system.Util.DbUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class BookingDaoImp implements BookingDao{

	 @Override
	    public void addBooking(Booking booking) {
	        try (EntityManager entityManager = DbUtil.getEntityManager()) {
	            EntityTransaction transaction = entityManager.getTransaction();
	            transaction.begin();
	            entityManager.persist(booking);
	            transaction.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public Booking getBookingById(int bookingId) {
	        try (EntityManager entityManager = DbUtil.getEntityManager()) {
	            return entityManager.find(Booking.class, bookingId);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	    @Override
	    public void updateBooking(Booking booking) {
	        try (EntityManager entityManager = DbUtil.getEntityManager()) {
	            EntityTransaction transaction = entityManager.getTransaction();
	            transaction.begin();
	            entityManager.merge(booking);
	            transaction.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void deleteBookingById(int bookingId) {
	        try (EntityManager entityManager = DbUtil.getEntityManager()) {
	            EntityTransaction transaction = entityManager.getTransaction();
	            transaction.begin();
	            Booking booking = entityManager.find(Booking.class, bookingId);
	            if (booking != null) {
	                entityManager.remove(booking);
	            }
	            transaction.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

		
	

}
