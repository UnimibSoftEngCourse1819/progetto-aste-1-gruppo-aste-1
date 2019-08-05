package com.project.aste.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="UserAccount")
public class UserAccount {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	@NotNull
	private String name;
	
	@Column(name="surname")
	@NotNull
	private String surname;
	
	@Column(name="email")
	@NotNull
	private String email;
	
	@Column(name="smsNotifications")
	@NotNull
	private boolean smsNotifications;
	
	@Column(name="emailNotification")
	@NotNull
	private boolean emailNotification;
	
	@Column(name="creditCardNumber")
	@NotNull
	private String creditCardNumber;
	
	@Column(name="numberOfCredits")
	@NotNull
	private int numberOfCredits;
	
	@Column(name="idAddress")
	private int idAddress;
	
	@Column(name="idAuthentication")
	private int idAuthentication;
	
	
	public UserAccount(int id, String name, String surname, String email, boolean smsNotifications,
			boolean emailNotification, String creditCardNumber, int numberOfCredits, int idAddress,
			int idAuthentication) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.smsNotifications = smsNotifications;
		this.emailNotification = emailNotification;
		this.creditCardNumber = creditCardNumber;
		this.numberOfCredits = numberOfCredits;
		this.idAddress = idAddress;
		this.idAuthentication = idAuthentication;
	}
	
	public int getId() {
		return id;
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
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isSmsNotifications() {
		return smsNotifications;
	}
	public void setSmsNotifications(boolean smsNotifications) {
		this.smsNotifications = smsNotifications;
	}
	public boolean isEmailNotification() {
		return emailNotification;
	}
	public void setEmailNotification(boolean emailNotification) {
		this.emailNotification = emailNotification;
	}
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	public int getNumberOfCredits() {
		return numberOfCredits;
	}
	public void setNumberOfCredits(int numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
	}
	public int getIdAddress() {
		return idAddress;
	}
	public void setIdAddress(int idAddress) {
		this.idAddress = idAddress;
	}
	public int getIdAuthentication() {
		return idAuthentication;
	}
	public void setIdAuthentication(int idAuthentication) {
		this.idAuthentication = idAuthentication;
	}
	
	
	
}
