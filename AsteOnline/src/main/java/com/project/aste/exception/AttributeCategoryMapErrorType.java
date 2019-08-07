package com.project.aste.exception;

import com.project.aste.entity.AttributeCategoryMap;

public class AttributeCategoryMapErrorType  extends AttributeCategoryMap {
	private String errorMessage;

	public AttributeCategoryMapErrorType(final String errorMessage) {
		this.errorMessage = errorMessage;
	}

	//@Override
	public String getErrorMessage() {
		return errorMessage;
	}
}
