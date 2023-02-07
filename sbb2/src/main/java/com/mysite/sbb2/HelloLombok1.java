package com.mysite.sbb2;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloLombok1 {

	private String name;
	private int age;
	
	public static void main(String[] args) {

		// 객체 생성
		HelloLombok1 hl = new HelloLombok1();
		
		// Setter
		hl.setName("김이경");
		hl.setAge(28);
		
		// Getter
		System.out.println("이름 : " + hl.getName());
		System.out.println("나이 : " + hl.getAge()+"세");
		
		// toString
		System.out.println(hl.toString());
	}

}
