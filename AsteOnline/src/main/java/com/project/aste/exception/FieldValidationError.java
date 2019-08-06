package com.project.aste.exception;

public class FieldValidationError {

	private String filed;
	private String message;
	private MessageType type;
	
	
	
	public MessageType getType() {
		return type;
	}
	public void setType(MessageType type) {
		this.type = type;
	}
	public String getFiled() {
		return filed;
	}
	public void setFiled(String filed) {
		this.filed = filed;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setType(java.awt.TrayIcon.MessageType error) {
		// TODO Auto-generated method stub
		
	}
	
}
