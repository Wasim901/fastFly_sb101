package com.masai.system.Util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DbUtil {
	
	static EntityManagerFactory emf;
	
	static {
		
		emf = Persistence.createEntityManagerFactory("fastFlySB101");
		
	}
	
	static EntityManager getEntityManager() {
		return emf.createEntityManager();
				
	}
	
	public static void main(String[] args) {
		
		System.out.println(getEntityManager());
		
		
	}
	
	

}
