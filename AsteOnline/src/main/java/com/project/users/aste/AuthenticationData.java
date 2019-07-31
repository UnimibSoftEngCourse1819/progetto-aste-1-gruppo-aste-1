package com.project.users.aste;

import java.util.Date;

public class AuthenticationData {
	
	private int idAuthentication;
	private int username;
	private int password;
	private Date registrationDatetime;
	private int idRole;
	
	public AuthenticationData(int idAuthentication, int username, int password, Date registrationDatetime, int idRole) {
		super();
		this.idAuthentication = idAuthentication;
		this.username = username;
		this.password = password;
		this.registrationDatetime = registrationDatetime;
		this.idRole = idRole;
	}

	public int getIdAuthentication() {
		return idAuthentication;
	}

	public void setIdAuthentication(int idAuthentication) {
		this.idAuthentication = idAuthentication;
	}

	public int getUsername() {
		return username;
	}

	public void setUsername(int username) {
		this.username = username;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public Date getRegistrationDatetime() {
		return registrationDatetime;
	}

	public void setRegistrationDatetime(Date registrationDatetime) {
		this.registrationDatetime = registrationDatetime;
	}

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	
	
	
	

}
