package org.jsp.votterTest;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestCfg {
	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		System.out.println(factory);
		
	}
}
