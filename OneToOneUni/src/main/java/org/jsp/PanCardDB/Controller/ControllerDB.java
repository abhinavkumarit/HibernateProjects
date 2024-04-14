package org.jsp.PanCardDB.Controller;

import java.util.Scanner;

import org.jsp.PanCardDB.Dao.PanCardDao;
import org.jsp.PanCardDB.Dto.PanCard;
import org.jsp.PanCardDB.Dto.User;

public class ControllerDB {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		User u=new User();
		PanCard p=new PanCard();
		PanCardDao dao=new PanCardDao();
		boolean res=true;
		while(res) {
			System.out.println("1. SaveRecord");
			System.out.println("2. FetchAllRecord");
			System.out.println("3. UpdateRecord");
			System.out.println("4. DeleteRecord");
			System.out.println("5. FetchUserByUserId");
			System.out.println("6. FetchPanCardByPanId");
			System.out.println("7. FetchPanCardByUserId");
			System.out.println("8. FindPandCardByUserNameAndUserPhoneNo.");
			System.out.println("9. Exit!");
			
			System.out.println("Enter your choice: ");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter userName:");
				u.setName(sc.next());
				System.out.println("Enter DOB:");
				u.setDOB(sc.next());
				System.out.println("Enter PhoneNo.: ");
				u.setPhone(sc.nextLong());
				System.out.println("Enter State:");
				p.setState(sc.next());
				System.out.println("Enter city:");
				p.setCity(sc.next());
				System.out.println("Enter FathersName:");
				p.setFatherName(sc.next());
				System.out.println("Enter CardNumber:");
				p.setCardNo(sc.nextLong());
				u.setCard(p);
				dao.saveRecords(u);
				break;
				
			case 2:
				dao.FindAllRecords();
				break;
				
			case 3:
				System.out.println("Enter user_id to update Record:");
				u.setUser_id(sc.nextInt());
				System.out.println("Enter UserName:");
				u.setName(sc.next());
				System.out.println("Enter DOB:");
				u.setDOB(sc.next());
				System.out.println("Enter PhoneNo.: ");
				u.setPhone(sc.nextLong());
				System.out.println("Enter State:");
				p.setState(sc.next());
				System.out.println("Enter city:");
				p.setCity(sc.next());
				System.out.println("Enter FathersName:");
				p.setFatherName(sc.next());
				System.out.println("Enter CardNumber:");
				p.setCardNo(sc.nextLong());
				u.setCard(p);
				dao.UpdateRecordByUserId(u);
				break;
			
			case 4:
				System.out.println("Enter userId:");
				u.setUser_id(sc.nextInt());
				dao.DeleteRecordByUserId(u);
				break;
				
			case 5:
				System.out.println("Enter userId:");
				u.setUser_id(sc.nextInt());
				dao.FindUserById(u);
				break;
			
			case 6:
				System.out.println("Enter PanId:");
				p.setId(sc.nextInt());
				dao.FindPanCardById(p);
				break;
				
			case 7:
				System.out.println("Enter userId:");
				u.setUser_id(sc.nextInt());
				dao.FindPanCardByUserId(u);
				break;
			
			case 8:
				System.out.println("Enter UserName:");
				u.setName(sc.next());
				System.out.println("Enter UserPhoneNumber:");
				u.setPhone(sc.nextLong());
				dao.FindPanCardByUserPhoneAndUserName(u);
				break;
			
			case 9:
				res=false;
				System.out.println("Thank you for visiting!");
				break;
			
				default:
					System.out.println("Invalid entry!");
					break;
			
			}
			
			
		}
		
		
	}

	
}
