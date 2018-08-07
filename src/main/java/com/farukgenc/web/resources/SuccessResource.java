package com.farukgenc.web.resources;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SuccessResource implements Serializable {

	private static final long serialVersionUID = 1603939482836084427L;

	@JsonProperty(value = "Success Status Code")
	private String statusCode;

	@JsonProperty(value = "Success Description")
	private String description;

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
