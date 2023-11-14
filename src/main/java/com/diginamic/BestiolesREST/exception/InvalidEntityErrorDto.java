package com.diginamic.BestiolesREST.exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

public class InvalidEntityErrorDto {

	private final Integer statusCode;
	private final LocalDateTime localDateTime;
	private final String message;
	private final String description;
	private final List<ObjectError> globalErrors;
	private final List<FieldError> fielderrors;
	
	public InvalidEntityErrorDto(Integer statusCode, LocalDateTime localDateTime, String message, String description,
			List<ObjectError> globalErrors, List<FieldError> fielderrors) {
		super();
		this.statusCode = statusCode;
		this.localDateTime = localDateTime;
		this.message = message;
		this.description = description;
		this.globalErrors = globalErrors;
		this.fielderrors = fielderrors;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public String getMessage() {
		return message;
	}

	public String getDescription() {
		return description;
	}

	public List<ObjectError> getGlobalErrors() {
		return globalErrors;
	}

	public List<FieldError> getFielderrors() {
		return fielderrors;
	}
	
}
