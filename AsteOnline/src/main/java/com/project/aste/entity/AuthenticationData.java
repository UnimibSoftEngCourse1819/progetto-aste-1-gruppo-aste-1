package com.project.aste.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AuthenticationData")
public class AuthenticationData {
	
	@Id
	@Column(name="idAuthentication")
	private int idAuthentication;

	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="registrationDatetime")
	private Date registrationDatetime;
	
	@Column(name="idRole")
	private int idRole;
	
	
	
	
	public AuthenticationData(int idAuthentication, String username, String password, Date registrationDatetime,
			int idRole) {
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
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
