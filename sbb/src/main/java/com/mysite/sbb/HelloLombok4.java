package com.mysite.sbb;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
//@NoArgsConstructor
@RequiredArgsConstructor // 생성자 생성 시 필드 이름 앞에 final이 들어가 있는 필드만 arguments(매개변수)로 생성
// @AllArgsConstructor
public class HelloLombok4 {

	private final String hello;
	private int lombok;

	/*		@RequiredArgsConstructor : 필드 이름 앞에 final 키가 할당된 필드만 arguments로 등록
	 * 		public HelloLombok4( String hello){
	 *			this.hello = hello; 		
	 * 		}
	 */
	public static void main(String[] args) {
		// @RequiredArgsConstructor 테스트
		HelloLombok4 lombok4 = new HelloLombok4("안녕");
		
		// toString() 메소드 호출
		System.out.println(lombok4.toString());
 
	}

}
