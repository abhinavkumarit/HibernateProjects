package org.jsp.PanCardDB.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.PanCardDB.Dto.PanCard;
import org.jsp.PanCardDB.Dto.User;

public class PanCardDao {
	EntityManager manager=Persistence.createEntityManagerFactory("development").createEntityManager();

	public void saveRecords(User u) {
		// TODO Auto-generated method stub
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		manager.persist(u);
//		manager.persist(u.getCard());
		transaction.commit();
		System.out.println("Data Saved!");
		
	}

	public void FindUserById(User u) {
		// TODO Auto-generated method stub
		User user=manager.find(User.class, u.getUser_id());
		if(user!=null) {
			System.out.println("--------------------------------");
			System.out.println("Name of user: "+user.getName());
			System.out.println("DOB of user: "+user.getDOB());
			System.out.println("Phone no of user: "+user.getPhone());
			
		}
		else {
			System.out.println("Failed to find!");
		}
		
	}

	public void FindPanCardById(PanCard p) {
		// TODO Auto-generated method stub
		PanCard card=manager.find(PanCard.class, p.getId());
		
		if(card!=null) {
			System.out.println("--------------------------------");
			System.out.println("Name of State: "+card.getState());
			System.out.println("Name of City: "+card.getCity());
			System.out.println("Fathers Name: "+card.getFatherName());
			System.out.println("Card Number: "+card.getCardNo());
			
		}
		else {
			System.out.println("Not Found!");
		}
		
	}

	public void FindPanCardByUserId(User u) {
		// TODO Auto-generated method 
		
		User user=manager.find(User.class, u.getUser_id());
		PanCard card=user.getCard();
		if(card!=null) {
			System.out.println("--------------------------------");
			System.out.println("Name of State: "+card.getState());
			System.out.println("Name of City: "+card.getCity());
			System.out.println("Fathers Name: "+card.getFatherName());
			System.out.println("Card Number: "+card.getCardNo());
		
		}
		else {
			System.out.println("Not Found!");
		}		
	}

	public void FindPanCardByUserPhoneAndUserName(User u) {
		// TODO Auto-generated method stub
		
		String qry="select u.card from User u where u.name=?1 and u.phone=?2";
		Query q=manager.createQuery(qry);
		q.setParameter(1, u.getName());
		q.setParameter(2, u.getPhone());
		
		PanCard card=(PanCard)q.getSingleResult();
		
		if(card!=null) {
			System.out.println("--------------------------------");
			System.out.println("Name of State: "+card.getState());
			System.out.println("Name of City: "+card.getCity());
			System.out.println("Fathers Name: "+card.getFatherName());
			System.out.println("Card Number: "+card.getCardNo());
			
		}
		else {
			System.out.println("Not Found!");
		}		
		
		
	}

	public void FindAllRecords() {
		
		String qry="select u from User u";
		Query q=manager.createQuery(qry);
		List<User>user=q.getResultList();
		
		
		if(user!=null) {
			for(User ut:user) {
				System.out.println("--------------------------------");
				System.out.println("Name of user: "+ut.getName());
				System.out.println("DOB of user: "+ut.getDOB());
				System.out.println("Phone no of user: "+ut.getPhone());
			}
		}
		else {
			System.out.println("Failed to handle!");
		}
		
	}
//	User user=new User();

	

	

	public void UpdateRecordByUserId(User u) {
		// TODO Auto-generated method stub
		EntityTransaction transaction=manager.getTransaction();
		User user=manager.find(User.class, u.getUser_id());
		PanCard card=manager.find(PanCard.class, user.getCard().getId());
		
		if(user!=null) {
			 // Update User details
	        transaction.begin();
	        user.setName(u.getName());
	        user.setDOB(u.getDOB());
	        user.setPhone(u.getPhone());
	        transaction.commit();

	        // Update PanCard details
	        transaction.begin();
	        card.setCardNo(u.getCard().getCardNo());
	        card.setCity(u.getCard().getCity());
	        card.setState(u.getCard().getState());
	        card.setFatherName(u.getCard().getFatherName());
	        transaction.commit();
		}
		System.out.println("unable to find");
	// In Update also .
		//PanCard details not getting updated.
//		so we use CascadeTypeAll so based on parentEntity childEntity gets updated
	}

	public void DeleteRecordByUserId(User u) {
		// TODO Auto-generated method stub
		EntityTransaction transaction=manager.getTransaction();
		User user=manager.find(User.class, u.getUser_id());
		if(user!=null) {
			transaction.begin();
			manager.remove(user);
			transaction.commit();
			System.out.println("User Record Deleted with id: "+u.getUser_id());
		}
		else {
			System.out.println("Failed to find user!");
		}
	
//		Deleting the parent entity (e.g., a User entity) does not automatically delete the associated child entity (e.g., a PanCard entity) in the database.
//		As we need to delete your child entity then parent entity
		
	}
		
	
	
	
}
