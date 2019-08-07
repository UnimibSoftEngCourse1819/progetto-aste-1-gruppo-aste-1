package com.project.aste.exception;

import com.project.aste.entity.Address;


public class AddressErrorType extends Address{
	
	private String errorMessage;
	public AddressErrorType(final String errorMessage) {
		this.errorMessage = errorMessage;
	}

	//@Override
	public String getErrorMessage() {
		return errorMessage;
	}
}
