package com.project.aste.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Notifications")
public class Notification {
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "idNotification")
	private int idNotification;
	
	@Column(name = "message")
	private String message;
	
	@Column(name = "idRecipient")
	private int idRecipient;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdNotification() {
		return idNotification;
	}
	public void setIdNotification(int idNotification) {
		this.idNotification = idNotification;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getIdRecipient() {
		return idRecipient;
	}
	public void setIdRecipient(int idRecipient) {
		this.idRecipient = idRecipient;
	}
	
	

}
