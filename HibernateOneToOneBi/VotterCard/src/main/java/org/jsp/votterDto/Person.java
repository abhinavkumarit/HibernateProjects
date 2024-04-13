package org.jsp.votterDto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String dob;
	@Column(nullable=false ,unique=true)
	private long phone;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="v_id")
	private VotterCard card;
	
	
	public int getId() {
		return id;
	}
	public VotterCard getCard() {
		return card;
	}
	public void setCard(VotterCard card) {
		this.card = card;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", dob=" + dob + ", phone=" + phone + ", card=" + card + "]";
	}
	
	
	
	
}
