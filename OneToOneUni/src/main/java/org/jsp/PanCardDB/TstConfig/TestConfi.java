package org.jsp.PanCardDB.TstConfig;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestConfi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		System.out.println(factory);
		
	}

}
