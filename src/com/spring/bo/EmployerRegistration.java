package com.spring.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emplr_reg")
public class EmployerRegistration {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="fein")
	private String fein;
	
	@Column(name="emplr_name")
	private String emplrName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone")
	private String phone;

	public EmployerRegistration() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the fein
	 */
	public String getFein() {
		return fein;
	}

	/**
	 * @param fein the fein to set
	 */
	public void setFein(String fein) {
		this.fein = fein;
	}

	/**
	 * @return the emplrName
	 */
	public String getEmplrName() {
		return emplrName;
	}

	/**
	 * @param emplrName the emplrName to set
	 */
	public void setEmplrName(String emplrName) {
		this.emplrName = emplrName;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
