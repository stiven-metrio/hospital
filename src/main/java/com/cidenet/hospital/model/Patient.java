package com.cidenet.hospital.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Patient entity
 * 
 * @author jsepulveda
 * @since April 2020
 */
@Entity
@Table(name = "patient")
public class Patient {
	private long patientId;
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	
	/**
	 * Default constructor
	 */
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor using fields
	 * 
	 * @param patientId
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param phone
	 */
	public Patient(long patientId, String id, String firstName, String lastName, String email, String phone) {
		super();
		this.patientId = patientId;
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}

	
	/**
	 * Getter for patientId
	 * @return patientId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "patient_id")
	public long getPatientId() {
		return patientId;
	}
	
	/**
	 * Setter for patientId
	 * @param patientId
	 */
	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}
	
	/**
	 * Getter for id
	 * @return id
	 */
	@Column(name = "id", nullable = false)
	public String getId() {
		return id;
	}
	
	/**
	 * Setter for id
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Getter for firstName
	 * @return firstName
	 */
	@Column(name = "first_name", nullable = false)
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Setter for firstName
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Getter for lastName
	 * @return lastName
	 */
	@Column(name = "last_name", nullable = false)
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Setter for lastName
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Getter for email
	 * @return email
	 */
	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}
	
	/**
	 * Setter for email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Getter for phone
	 * @return phone
	 */
	@Column(name = "phone", nullable = false)
	public String getPhone() {
		return phone;
	}
	
	/**
	 * Setter for phone
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
    @Override
    public String toString() {
        return "Patient [patient_id=" + patientId + ", id=" + id + ", first_name=" + firstName + ", last_name=" + lastName 
        		+ ", email=" + email + ", phone=" + phone + "]";
    }
	
}
