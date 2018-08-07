package com.farukgenc.exception;

public class StudentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 4073892260015028514L;

	private String statusCode;
	private String description;

	public StudentNotFoundException(String statusCode, String description) {
		this.statusCode = statusCode;
		this.description = description;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
