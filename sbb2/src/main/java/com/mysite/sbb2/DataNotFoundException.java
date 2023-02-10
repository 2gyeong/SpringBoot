package com.mysite.sbb2;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "요청 레코드를 못 찾았습니다.")
public class DataNotFoundException extends Exception {
	private static final long serialVersionUID = 1L ;
	
	public DataNotFoundException (String message) {
		super(message);
	}
}
