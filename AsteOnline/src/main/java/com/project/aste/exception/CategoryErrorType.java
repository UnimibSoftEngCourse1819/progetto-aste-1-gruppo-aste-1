package com.project.aste.exception;

import com.project.aste.entity.Category;

public class CategoryErrorType extends Category {

	private String errorMessage;

	public CategoryErrorType(final String errorMessage) {
		this.errorMessage = errorMessage;
	}

	//@Override
	public String getErrorMessage() {
		return errorMessage;
	}
	
}
