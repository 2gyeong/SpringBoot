package com.washour.www;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.washour.www.qeustion.Question;
import com.washour.www.qeustion.QuestionRepository;


@SpringBootTest
class MyProjectApplicationTests {

	@Autowired		// 객체 자동 주입, JPA의 CRUD할 수 있는 메소드가 적용되어 있음.
	private QuestionRepository questionRepository;
	
	
	@Test
	void testJpa() {
		Question q1 = new Question();
        q1.setSubject("배송문의");
        q1.setContent("배송 언제 되나요?");
        q1.setCreateDate(LocalDateTime.now());
        q1.setAuthor(null);
        this.questionRepository.save(q1);  // 첫번째 질문 저장
	}

}
