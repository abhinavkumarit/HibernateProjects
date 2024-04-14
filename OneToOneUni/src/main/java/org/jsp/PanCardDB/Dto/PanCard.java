package org.jsp.PanCardDB.Dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PanCard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false, unique=true)
	private long cardNo;
	@Column(nullable=false)
	private String State;
	@Column(nullable=false)
	private String city;
	@Column(nullable=false)
	private String fatherName;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getCardNo() {
		return cardNo;
	}
	public void setCardNo(long cardNo) {
		this.cardNo = cardNo;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	@Override
	public String toString() {
		return "PanCard [id=" + id + ", cardNo=" + cardNo + ", State=" + State + ", city=" + city + ", fatherName="
				+ fatherName + "]";
	}
	
	
	
	
}
