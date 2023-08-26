package com.masai.system.DAO;

import java.util.Collections;
import java.util.List;

import com.masai.system.DTO.Flight;
import com.masai.system.Util.DbUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class FlightDaoImp implements FlightDao{
	
	  
	  @Override
	    public void addFlight(Flight flight) {
	        try (EntityManager entityManager = DbUtil.getEntityManager()) {
	            EntityTransaction transaction = entityManager.getTransaction();
	            transaction.begin();
	            entityManager.persist(flight);
	            transaction.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public Flight getFlightById(int flightId) {
	        try (EntityManager entityManager = DbUtil.getEntityManager()) {
	            return entityManager.find(Flight.class, flightId);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	    @Override
	    public List<Flight> getAllFlights() {
	        try (EntityManager entityManager = DbUtil.getEntityManager()) {
	            return entityManager.createQuery("SELECT f FROM Flight f", Flight.class).getResultList();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return Collections.emptyList();
	        }
	    }

	    @Override
	    public void updateFlight(Flight flight) {
	        try (EntityManager entityManager = DbUtil.getEntityManager()) {
	            EntityTransaction transaction = entityManager.getTransaction();
	            transaction.begin();
	            entityManager.merge(flight);
	            transaction.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void deleteFlightById(int flightId) {
	        try (EntityManager entityManager = DbUtil.getEntityManager()) {
	            EntityTransaction transaction = entityManager.getTransaction();
	            transaction.begin();
	            Flight flight = entityManager.find(Flight.class, flightId);
	            if (flight != null) {
	                entityManager.remove(flight);
	            }
	            transaction.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    @Override
	    public List<Flight> searchFlights(String departureCity, String destinationCity, String departureDate) {
	        EntityManager entityManager = DbUtil.getEntityManager();

	        String jpql = "SELECT f FROM Flight f WHERE f.departureCity = :departureCity " +
	                "AND f.destinationCity = :destinationCity AND f.departureDate = :departureDate";

	        TypedQuery<Flight> query = entityManager.createQuery(jpql, Flight.class);
	        query.setParameter("departureCity", departureCity);
	        query.setParameter("destinationCity", destinationCity);
	        query.setParameter("departureDate", departureDate);

	        List<Flight> flights = query.getResultList();

	        entityManager.close();

	        return flights;
	    }
	    
	    
	}


