package com.project.aste.exception;


import com.project.aste.entity.AuthenticationData;


public class AuthenticationDataErrorType extends AuthenticationData{
	
	private String errorMessage;
	public AuthenticationDataErrorType(final String errorMessage) {
		this.errorMessage = errorMessage;
	}

	//@Override
	public String getErrorMessage() {
		return errorMessage;
	}
}
