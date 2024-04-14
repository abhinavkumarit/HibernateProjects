package org.jsp.PanCardDB.Dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false, unique=true)
	private long phone;
	@Column(nullable=false)
	private String DOB;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="pan_id")
	private PanCard card;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public PanCard getCard() {
		return card;
	}
	public void setCard(PanCard card) {
		this.card = card;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", name=" + name + ", phone=" + phone + ", DOB=" + DOB + ", card=" + card
				+ "]";
	}
	
	
}
