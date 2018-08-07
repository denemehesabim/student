package com.farukgenc.web.resources;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResource implements Serializable {

	private static final long serialVersionUID = -8988482419228073324L;

	@JsonProperty(value = "Error Status Code")
	private String statusCode;

	@JsonProperty(value = "Error Description")
	private String description;

	public ErrorResource(String statusCode, String description) {
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
