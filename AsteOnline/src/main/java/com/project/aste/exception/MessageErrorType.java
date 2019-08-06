package com.project.aste.exception;

import com.project.aste.entity.UserAccount;

public class MessageErrorType extends UserAccount
{
	private String errorMessage;
	
	public MessageErrorType(final String errorMessage) {
		this.errorMessage = errorMessage;
	}

	//@Override
	public String getErrorMessage() {
		return errorMessage;
	}
}
