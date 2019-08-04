package com.project.aste.exception;

public class UserErrorType {
	private String errorMessage;

	public UserErrorType(final String errorMessage) {
		this.errorMessage = errorMessage;
	}

	//@Override
	public String getErrorMessage() {
		return errorMessage;
	}
}
