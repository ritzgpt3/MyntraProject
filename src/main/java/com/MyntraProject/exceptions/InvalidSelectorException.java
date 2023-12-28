package com.MyntraProject.exceptions;

public class InvalidSelectorException extends RuntimeException {
	String locatorType;

	public InvalidSelectorException(String locatorType) {
		this.locatorType = locatorType;
	}

	public String getMessage() {
		return "Invalid locatorType" + locatorType;

	}
}
