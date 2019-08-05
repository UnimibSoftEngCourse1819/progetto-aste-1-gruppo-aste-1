package com.project.aste.exception;

import com.project.aste.entity.AuthenticationData;

//
public class UserErrorType /*extends AuthenticationData*/{
	private String errorMessage;

	public UserErrorType(final String errorMessage) {
		this.errorMessage = errorMessage;
	}

	//@Override
	public String getErrorMessage() {
		return errorMessage;
	}
}
