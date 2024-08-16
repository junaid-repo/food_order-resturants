package com.food.resturants.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	Map<String, String> entityValidation(MethodArgumentNotValidException ex) {

		Map<String, String> errMap = new HashMap<>();

		ex.getBindingResult().getAllErrors().forEach(err -> {
			errMap.put(((FieldError) err).getField(), err.getDefaultMessage());
		});

		return errMap;
	}

}
