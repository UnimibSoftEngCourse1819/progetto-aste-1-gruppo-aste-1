package com.project.aste.exception;

import com.project.aste.entity.UserAccount;

//
public class CustomErrorType extends UserAccount{
	private String errorMessage;

	public CustomErrorType(final String errorMessage) {
		this.errorMessage = errorMessage;
	}

	//@Override
	public String getErrorMessage() {
		return errorMessage;
	}
}
