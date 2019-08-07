package com.project.aste.exception;

import com.project.aste.entity.ObjectService;

public class ObjectServiceErrorType extends ObjectService{
	private String errorMessage;

	public ObjectServiceErrorType(final String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
