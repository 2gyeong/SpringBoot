package com.mysite.sbb.user;

import lombok.Getter;

/* enum : 열거형 자료형
 * 
 * 
 * 
 * */



@Getter
public enum UserRole {

	ADMIN("ROLE_ADMIN"),
	
	USER("ROLE_USER");
	
	UserRole(String value){
		this.value = value;
	}
	
	private String value;
}
