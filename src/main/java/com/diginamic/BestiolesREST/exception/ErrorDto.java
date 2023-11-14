package com.diginamic.BestiolesREST.exception;

import java.time.LocalDateTime;

public class ErrorDto {
	
	private final Integer statusCode;
	private final LocalDateTime localDateTime;
	private final String message;
	private final String description;
	
	public ErrorDto(Integer statusCode, LocalDateTime localDateTime, String message, String description) {
		super();
		this.statusCode = statusCode;
		this.localDateTime = localDateTime;
		this.message = message;
		this.description = description;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public String getMessagee() {
		return message;
	}

	public String getDescription() {
		return description;
	} 
	
}
