package com.mysite.sbb2;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "요청한 파일을 찾지 못했습니다.")
public class DataNotFoundException extends Exception {
	private static final long serialVersionUIDX = 1L ;
	
	public DataNotFoundException (String message) {
		super(message);
	}
}
