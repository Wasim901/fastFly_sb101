package com.masai.system.DAO;

import com.masai.system.DTO.Admin;
import com.masai.system.Util.DbUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class AdminDaoImp implements AdminDao{

	 @Override
	  public void addAdmin(Admin admin) {
	        try (EntityManager entityManager = DbUtil.getEntityManager()) {
	            EntityTransaction transaction = entityManager.getTransaction();
	            transaction.begin();
	            entityManager.persist(admin);
	            transaction.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public Admin getAdminById(int adminId) {
	        try (EntityManager entityManager = DbUtil.getEntityManager()) {
	            return entityManager.find(Admin.class, adminId);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	    @Override
	    public Admin getAdminByUsername(String username) {
	        try (EntityManager entityManager = DbUtil.getEntityManager()) {
	            return entityManager.createQuery("SELECT a FROM Admin a WHERE a.username = :username", Admin.class)
	                    .setParameter("username", username)
	                    .getSingleResult();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	    @Override
	    public void updateAdmin(Admin admin) {
	        try (EntityManager entityManager = DbUtil.getEntityManager()) {
	            EntityTransaction transaction = entityManager.getTransaction();
	            transaction.begin();
	            entityManager.merge(admin);
	            transaction.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void deleteAdminById(int adminId) {
	        try (EntityManager entityManager = DbUtil.getEntityManager()) {
	            EntityTransaction transaction = entityManager.getTransaction();
	            transaction.begin();
	            Admin admin = entityManager.find(Admin.class, adminId);
	            if (admin != null) {
	                entityManager.remove(admin);
	            }
	            transaction.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
