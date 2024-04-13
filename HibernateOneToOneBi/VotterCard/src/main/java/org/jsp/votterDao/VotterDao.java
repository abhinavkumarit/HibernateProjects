package org.jsp.votterDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.votterDto.Person;
import org.jsp.votterDto.VotterCard;

public class VotterDao {
	
	
	EntityManager manager=Persistence.createEntityManagerFactory("development").createEntityManager();
	public void saveDetails(Person person) {
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		manager.persist(person);
		transaction.commit();
		System.out.println("Data saved successfully!");
	}
	
	public void FetchAllRecord() {
		String qry="select p from Person p";
		Query q=manager.createQuery(qry);
		
		List<Person>person=q.getResultList();
		if(person!=null) {
			for(Person p: person) {
				System.out.println("ID:"+p.getId());
				System.out.println("Name:"+p.getName());
				System.out.println("DOB: "+p.getDob());
				System.out.println("------------------");
		
			}
		}
		else {
//			return null;
			System.out.println("Not Found!");
		}
//		return person;
//		return person;
	}

	public void FetchById(Person person) {
		// TODO Auto-generated method stub
//		return null;
		String qry="select p from Person p where p.id=?1";
		EntityTransaction transaction=manager.getTransaction();
		Query q=manager.createQuery(qry);
		q.setParameter(1, person.getId());

			Person person2=(Person) q.getSingleResult();
	
				System.out.println("ID:"+person2.getId());
				System.out.println("Name:"+person2.getName());
				System.out.println("DOB: "+person2.getDob());
				System.out.println("------------------");
		
				
		}

	public void FetchVotterCardById(Person person) {
		// TODO Auto-generated method stub
		String qry="select p.card from Person p where p.id=?1";
		EntityTransaction transaction=manager.getTransaction();
		Query q=manager.createQuery(qry);
		q.setParameter(1, person.getId());
		VotterCard vt=(VotterCard) q.getSingleResult();
		
		System.out.println("ID:"+vt.getId());
		System.out.println("State:"+vt.getState());
		System.out.println("City: "+vt.getCity());
		System.out.println("CardNo.:"+vt.getCard_id());
		System.out.println("------------------");
		
	}

	public void FetchPersonRecordByCardId(VotterCard card) {
		// TODO Auto-generated method stub
		String qry="select v.person from VotterCard v where v.card_id=?1";
		EntityTransaction transaction=manager.getTransaction();
		Query q=manager.createQuery(qry);
		q.setParameter(1, card.getCard_id());
		Person person2=(Person)q.getSingleResult();
		System.out.println("ID:"+person2.getId());
		System.out.println("Name:"+person2.getName());
		System.out.println("DOB: "+person2.getDob());
		System.out.println("------------------");
		
		
	}

	public void FetVotterCardByVotterId(VotterCard card) {
		// TODO Auto-generated method stub
		String qry="select v from VotterCard v where v.card_id=?1";
		Query q=manager.createQuery(qry);
		q.setParameter(1, card.getId());
		VotterCard vt=(VotterCard)q.getSingleResult();
		System.out.println("ID:"+vt.getId());
		System.out.println("State:"+vt.getState());
		System.out.println("City: "+vt.getCity());
		System.out.println("CardNo.:"+vt.getCard_id());
		System.out.println("------------------");
		
	}

	public void FetchVotterCardByPhone(Person person) {
		// TODO Auto-generated method stub
		String qry="select p.card from Person p where p.phone=?1";
		Query q=manager.createQuery(qry);
		q.setParameter(1, person.getPhone());
		VotterCard vt=(VotterCard)q.getSingleResult();
		System.out.println("ID:"+vt.getId());
		System.out.println("State:"+vt.getState());
		System.out.println("City: "+vt.getCity());
		System.out.println("CardNo.:"+vt.getCard_id());
		System.out.println("------------------");
		
	}

	public void FetchVotterCardByCardIdAndCardNo(VotterCard card) {
		// TODO Auto-generated method stub
		String qry="select v from VotterCard v where v.card_id=?1 and v.id=?2";
		Query q=manager.createQuery(qry);
		q.setParameter(1, card.getCard_id());
		q.setParameter(2, card.getId());
		
		VotterCard vt=(VotterCard)q.getSingleResult();
		System.out.println("ID:"+vt.getId());
		System.out.println("State:"+vt.getState());
		System.out.println("City: "+vt.getCity());
		System.out.println("CardNo.:"+vt.getCard_id());
		System.out.println("------------------");
		
	}

	public void UpdatePersonRecord(Person person) {
		// TODO Auto-generated method stub
		Person p=manager.find(Person.class, person.getId());
		
		if(p!=null) {
			EntityTransaction transaction=manager.getTransaction();
			transaction.begin();
			p.setName(person.getName());
			p.setDob(person.getDob());
			p.setPhone(person.getPhone());
			manager.merge(p);
			transaction.commit();
			System.out.println("Record updated of: "+p.getId());
		}
		else {
			System.out.println("Not Found!");
		}
	}

	public void UpdateVotterCardRecord(VotterCard card) {
		// TODO Auto-generated method stub
		
		VotterCard vt=manager.find(VotterCard.class, card.getId());
		
		if(vt!=null) {
			EntityTransaction transaction=manager.getTransaction();
			transaction.begin();
			vt.setCard_id(card.getCard_id());
			vt.setCity(card.getCity());
			vt.setState(card.getState());
			manager.merge(vt);
			transaction.commit();
			System.out.println("Record updated of: "+vt.getId());
		}
		else {
			System.out.println("Not Found!");
		}
		
	}

	public void DeleteRecordByPersonId(Person person) {
		// TODO Auto-generated method stub
		Person p=manager.find(Person.class, person.getId());
		
		
		if(p!=null) {
			
			EntityTransaction transaction=manager.getTransaction();
			transaction.begin();
			manager.remove(p);
			transaction.commit();
			System.out.println("Record deleted with id: "+person.getId());
		}
		else {
			System.out.println("Not Found!");
		}
		
		
	}

	
		
	
	}

//	public void UpdateRecord(Person person) {
//		// TODO Auto-generated method stub
//		Person p=manager.find(Person.class, person.getId());
//		
//		
//		if(p!=null) {
//			EntityTransaction transaction=manager.getTransaction();
//			transaction.begin();
////			manager.merge(p);
//			p.setName(person.getName());
//			p.setDob(person.getDob());
//			p.setPhone(person.getPhone());
//			p.setCard(person.getCard());
//			
//			
//			transaction.commit();
//			System.out.println("Record Updated of:"+p.getId());
//		}
//		else {
//			System.out.println("Not Found!");
//		}
//	}
	
	
	

