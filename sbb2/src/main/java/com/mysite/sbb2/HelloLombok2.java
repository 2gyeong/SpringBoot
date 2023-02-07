package com.mysite.sbb2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
//@NoArgsConstructor
@AllArgsConstructor
public class HelloLombok2 {
	
	private String name;
	private int age;

	public static void main(String[] args) {
		
		HelloLombok2 hl2 = new HelloLombok2("김이경", 28);
		
		System.out.println(hl2.toString());

	}

}
