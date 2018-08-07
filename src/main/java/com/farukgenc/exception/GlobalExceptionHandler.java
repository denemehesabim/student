package com.farukgenc.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.farukgenc.web.resources.ErrorResource;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = StudentNotFoundException.class)
	public @ResponseBody ResponseEntity<ErrorResource> studentNotFoundException(HttpServletRequest req,
			StudentNotFoundException e) throws Exception {
		return new ResponseEntity<ErrorResource>(new ErrorResource(e.getStatusCode(), e.getDescription()),
				HttpStatus.NOT_FOUND);
	}

}
