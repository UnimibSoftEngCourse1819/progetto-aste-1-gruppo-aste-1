package com.project.aste.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.CreditCardNumber;

@Entity
@Table(name="UsersAccount")
public class UserAccount {
	
	public UserAccount(){};
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	@NotEmpty(message = "error.name.empty")
	private String name;
	
	@Column(name="surname")
	@NotEmpty(message = "error.surname.empty")
	private String surname;
	
	
	@Column(name="email")
	@Email(message = "error.email.email")
	@NotEmpty(message = "error.email.empty")
	private String email;
	
	@Column(name="telephone")
	@NotEmpty(message = "error.telephone.empty")
	private String telephone;
	
	@Column(name="smsNotifications")
	@NotNull
	private boolean smsNotifications;
	
	
	@Column(name="emailNotifications")
	@NotNull
	private boolean emailNotification;
	
	@Column(name="creditCardNumber")
	@NotEmpty(message = "error.creditCardNumber.empty")
	@CreditCardNumber(message = "error.creditCardNumber.creditCardNumber")
	private String creditCardNumber;
	
	@Column(name="numberOfCredits")
	@NotNull
	private int numberOfCredits;
	
	@Column(name="idAddress")
	private int idAddress;
	
	@Column(name="idAuthentication")
	private int idAuthentication;
	
	
	/*public UserAccount(int id, String name, String surname, String email, boolean smsNotifications,
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
	}*/
	
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
	
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
