package com.project.aste.exception;
import com.project.aste.entity.Attribute;

public class AttributeErrorType extends Attribute{
	private String errorMessage;

	public AttributeErrorType(final String errorMessage) {
		this.errorMessage = errorMessage;
	}

	//@Override
	public String getErrorMessage() {
		return errorMessage;
	}
}
