package com.mysite.sbb;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SbbApplicationTests {
	
	@Autowired		// 객체 자동 주입, JPA의 CRUD할 수 있는 메소드가 적용되어 있음.
	private QuestionRepository questionRepository;
	
	/* 조건에 맞는 레코드 하나만 가져 오기 */
	@Test
	public void jpaTestget() {
		Optional<Question> oq = this.questionRepository.findById(1);
		
		if(oq.isPresent()) {		// isPresent : 존재 여부 확인 
			Question q = oq.get();
			System.out.println(q.getId());
			System.out.println(q.getSubject());
			System.out.println(q.getContent());
			System.out.println(q.getCreateDate());
		}
	}
	

	
	/* Select List JUnit Test 
	
	@Test
	public void jpaTest() {
		List<Question> all = this.questionRepository.findAll();
		assertEquals(6, all.size());	// assertEquals(기대값, 실제값), 성공(두 값이 일치)
		
		Question q = all.get(4);	//List all 변수에 담긴 0번 방의 Question 객체를 끄집어
		assertEquals("sbb가 무엇인가요", q.getSubject());	// 성공
		
		System.out.println("Id 값 : " + q.getId());
		System.out.println("제목 : " + q.getSubject());
		System.out.println("내용 : " + q.getContent());
	}
	*/
	
	
	
	
	// findall : 모든 레코드를 DB 값을 가져온다.
	//  DB에서 값을 가져와서 setter주입으로 모든 객체를 List에 저장.

/* Insert JUnit Test , JPA 인터페이스에 정의 된 save()
 * 추상화
	@Test
	void contextLoads() {
		Question q1 = new Question();
		q1.setSubject("sbb가 무엇인가요");
		q1.setContent("sbb에 대해서 알고 싶습니다.");
		q1.setCreateDate(LocalDateTime.now()); // 현재 시간을 setter에 저장
		this.questionRepository.save(q1);	// 첫 번째 질문 저장
		
		Question q2 = new Question();
		q2.setSubject("스프링부트 모델 질문입니다.");
		q2.setContent("id는 자동으로 생성되나요?");
		q2.setCreateDate(LocalDateTime.now()); // 현재 시간을 setter에 저장
		this.questionRepository.save(q2);
	}
*/
}

