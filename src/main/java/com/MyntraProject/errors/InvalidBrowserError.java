package com.MyntraProject.errors;

public class InvalidBrowserError extends Error{
	String browserName;

	public InvalidBrowserError(String browserName) {
		this.browserName = browserName;
	}

	public String getMessage() {
		return "Invalid browser name" + browserName;

	}
}
