package com.example.goodWriting.domain.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.goodWriting.common.CommonResponse;
import com.example.goodWriting.domain.user.exception.PasswordNotMatchedException;
import com.example.goodWriting.domain.user.exception.UserEmailAlreadyException;
import com.example.goodWriting.domain.user.exception.UserErrorCode;

import jakarta.servlet.http.HttpServletRequest;


@RestControllerAdvice
public class UserControllerAdvice {

	@ExceptionHandler(UserEmailAlreadyException.class)
	public ResponseEntity userEmailAlreadyException(HttpServletRequest request) {
		return ResponseEntity.status(UserErrorCode.SAME_EMAIL_ALREADY_EXIST.getCode())
			.body(CommonResponse.builder()
				.path(request.getRequestURI())
				.method(request.getMethod())
				.message(UserErrorCode.SAME_EMAIL_ALREADY_EXIST.getMsg())
				.statusCode(UserErrorCode.SAME_EMAIL_ALREADY_EXIST.getCode())
				.build());
	}


	@ExceptionHandler(PasswordNotMatchedException.class)
	public ResponseEntity passwordNotMatchedException(HttpServletRequest request) {
		return ResponseEntity.status(UserErrorCode.PASSWORD_NOT_MATCHED.getCode())
			.body(CommonResponse.builder()
				.path(request.getRequestURI())
				.method(request.getMethod())
				.message(UserErrorCode.PASSWORD_NOT_MATCHED.getMsg())
				.statusCode(UserErrorCode.PASSWORD_NOT_MATCHED.getCode())
				.build());
	}


}
