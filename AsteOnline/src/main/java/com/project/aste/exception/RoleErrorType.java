package com.project.aste.exception;

import com.project.aste.entity.Role;

public class RoleErrorType extends Role {

	private String errorMessage;
	public RoleErrorType(final String errorMessage) {
		this.errorMessage = errorMessage;
	}

	//@Override
	public String getErrorMessage() {
		return errorMessage;
	}	
	
	
}


