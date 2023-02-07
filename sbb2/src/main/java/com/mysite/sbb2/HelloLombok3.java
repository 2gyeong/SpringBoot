package com.mysite.sbb2;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
public class HelloLombok3 {
	
	private final String name;
	private int age;

	public static void main(String[] args) {
		
		// HelloLombok3 hl3 = new HelloLombok3("김이경", 28); // 오류
		HelloLombok3 hl3 = new HelloLombok3("김이경");
		System.out.println(hl3.toString());

	}

}