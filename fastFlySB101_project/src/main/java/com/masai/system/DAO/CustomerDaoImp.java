package com.masai.system.DAO;

import com.masai.system.DTO.Booking;
import com.masai.system.DTO.Customer;
import com.masai.system.Util.DbUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class CustomerDaoImp implements CustomerDao{

	 @Override
	    public void addCustomer(Customer customer) {
	        try (EntityManager entityManager = DbUtil.getEntityManager()) {
	            EntityTransaction transaction = entityManager.getTransaction();
	            transaction.begin();
	            entityManager.persist(customer);
	            transaction.commit();
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	    }

	 @Override
	 public Customer getCustomerById(int customerId) {
	        try (EntityManager entityManager = DbUtil.getEntityManager()) {
	            return entityManager.find(Customer.class, customerId);
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	            return null;
	        }
	    }

	 @Override
	    public Customer getCustomerByEmail(String email) {
	        try (EntityManager entityManager = DbUtil.getEntityManager()) {
	            return entityManager.createQuery("SELECT c FROM Customer c WHERE c.email = :email", Customer.class)
	                  .setParameter("email", email)
	                    .getSingleResult();
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	            return null;
	        }
	    }

	 @Override
	    public void updateCustomer(Customer customer) {
	        try (EntityManager entityManager = DbUtil.getEntityManager()) {
	            EntityTransaction transaction = entityManager.getTransaction();
	            transaction.begin();
	            entityManager.merge(customer);
	            transaction.commit();
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	    }

	  @Override
	  public void deleteCustomerById(int customerId) {
        try (EntityManager entityManager = DbUtil.getEntityManager()) {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Customer customer = entityManager.find(Customer.class, customerId);
            if (customer != null) {
                entityManager.remove(customer);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	  
	  
	  @Override
	    public Booking getBookingById(int bookingId) {
	        EntityManager entityManager = DbUtil.getEntityManager();
	        Booking booking = entityManager.find(Booking.class, bookingId);
	        entityManager.close();
	        return booking;
	    }
	
	

}
