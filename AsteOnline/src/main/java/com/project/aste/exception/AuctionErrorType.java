package com.project.aste.exception;

import com.project.aste.entity.Auction;

public class AuctionErrorType extends Auction{
	private String errorMessage;
	public AuctionErrorType(final String errorMessage) {
		this.errorMessage = errorMessage;
	}

	//@Override
	public String getErrorMessage() {
		return errorMessage;
	}
}
