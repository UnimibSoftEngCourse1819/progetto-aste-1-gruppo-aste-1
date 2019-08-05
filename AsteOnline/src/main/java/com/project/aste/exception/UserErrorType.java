package com.project.aste.exception;

import com.project.aste.entity.UserAccount;

//
public class UserErrorType extends UserAccount{
	private String errorMessage;

	public UserErrorType(final String errorMessage) {
		this.errorMessage = errorMessage;
	}

	//@Override
	public String getErrorMessage() {
		return errorMessage;
	}
}
