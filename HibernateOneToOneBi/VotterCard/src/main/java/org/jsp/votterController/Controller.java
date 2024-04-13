package org.jsp.votterController;

import java.util.Scanner;

import org.jsp.votterDao.VotterDao;
import org.jsp.votterDto.Person;
import org.jsp.votterDto.VotterCard;

public class Controller {
	public static void main(String[] args) {
		VotterDao dao=new VotterDao();
		Person person=new Person();
		boolean res=true;
		
		while(res) {
			VotterCard card=new VotterCard();
			System.out.println("1. SaveRecords");
			System.out.println("2. FetchAllRecords");
			System.out.println("3. UpdatePersonDetailsByPersonById");
			System.out.println("4. UpdateVotterDetailsByVotterId");
			System.out.println("5. FetchPersonDetailsByPerson_Id");
			System.out.println("6. FetchVotterCardDetailsByVotter_Id");
			System.out.println("7. FetchVotterDetailsByPersonId");
			System.out.println("8. FetchPersonDetailsByCardNo.");
			System.out.println("9. FindVotterDetailsByPhoneNo.");
			System.out.println("10.FindVotterCardByVotterNoAndVotterId");
			System.out.println("11.DeleteRecordByPersonId:");
			System.out.println("12.Exit");
			
			
			
			Scanner sc=new Scanner(System.in);
			int choice=sc.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("Enter name:");
				person.setName(sc.next());
				System.out.println("Enter phone:");
				person.setPhone(sc.nextLong());
				System.out.println("Enter DOB:");
				person.setDob(sc.next());
				System.out.println("Enter card_id");
				card.setCard_id(sc.nextLong());
				System.out.println("Enter city:");
				card.setCity(sc.next());
				System.out.println("Enter state:");
				card.setState(sc.next());
				person.setCard(card);
				card.setPerson(person);
				dao.saveDetails(person);
				break;
				
			case 2:
				System.out.println("Enter Fetch records:");
				dao.FetchAllRecord();
				break;
				
				
				
				
			case 3:
				System.out.println("Enter PersonId:");
				person.setId(sc.nextInt());
				System.out.println("Enter Person name:");
				person.setName(sc.next());
				System.out.println("Enter Person phoneNo:");
				person.setPhone(sc.nextLong());
				System.out.println("Enter Person DOB:");
				person.setDob(sc.next());
				dao.UpdatePersonRecord(person);
				break;
				
			case 4:
				System.out.println("Enter VotterId:");
				card.setId(sc.nextInt());
				System.out.println("Enter VotterCardNumber:");
				card.setCard_id(sc.nextLong());
				System.out.println("Enter City:");
				card.setCity(sc.next());
				System.out.println("Enter State:");
				card.setState(sc.next());
				dao.UpdateVotterCardRecord(card);
				break;
				
				
			case 5:
				System.out.println("Enter id to Fetch record:");
				person.setId(sc.nextInt());
				dao.FetchById(person);
				break;
				
			case 6:
				System.out.println("Enter Votter_id to fetch VotterDetails:");
				card.setId(sc.nextInt());
				dao.FetVotterCardByVotterId(card);
				break;
					
					
				case 7:
					System.out.println("Enter id to Fetch votter details:");
					person.setId(sc.nextInt());
					dao.FetchVotterCardById(person);
					break;
					
					
				case 8:
					System.out.println("Enter CardNo. to Fetch Person Details:");
					card.setCard_id(sc.nextLong());
					dao.FetchPersonRecordByCardId(card);
					
					break;
					
				case 9:
					System.out.println("Enter phoneNumber to find VotterDetails:");
					person.setPhone(sc.nextLong());
					dao.FetchVotterCardByPhone(person);
					break;
					
				case 10:
					System.out.println("Enter AddharNumber:");
					card.setCard_id(sc.nextLong());
					System.out.println("Enter Addhar_id:");
					card.setId(sc.nextInt());
					dao.FetchVotterCardByCardIdAndCardNo(card);
					break;
					
				case 11:
					System.out.println("Enter PersonId:");
					person.setId(sc.nextInt());
					dao.DeleteRecordByPersonId(person);
					break;
					
				case 12:
					System.out.println("Thanks for visiting");
					res=false;
					break;
					
				default:
					System.out.println("Invalid!");
					
					break;
			}

		}
				
	}
}
