package com.mysite.sbb;
import java.sql.Date;
import java.util.Calendar;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class HelloLombok2 {
	
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regdate ;
	private int cnt;


	public static void main(String[] args) {
		// 객체 생성 후 테스트
		
		HelloLombok2 lombok = new HelloLombok2();
		
		lombok.setSeq(20);
		lombok.setTitle("제목입니다.");
		lombok.setWriter("작성자");
		lombok.setContent("내용입니다.");

		
	//	lombok.setRegdate();
		lombok.setCnt(1);
		
		// getter를 사용해서 lombok2객체에 저장된 메모리 필드의 값을 출력
		
		
		System.out.println(lombok.getSeq());
		System.out.println(lombok.getTitle());
		System.out.println(lombok.getWriter());
		System.out.println(lombok.getContent());
		System.out.println(lombok.getRegdate());
		System.out.println(lombok.getCnt());
		
		// toString() 메소드 호출 : 객체 자체를 print
		System.out.println(lombok.toString());
		
	}

}
