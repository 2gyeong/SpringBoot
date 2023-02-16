package com.mysite.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.answer.AnswerRepository;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;

@SpringBootTest
class SbbApplicationTests {
	
	@Autowired		// 객체 자동 주입, JPA의 CRUD할 수 있는 메소드가 적용되어 있음.
	private QuestionRepository questionRepository;
	
	@Autowired	// 객체 자동 주입 (DI) , JPA의 메소드를 사용, findAll(), findId(), save(), delete()
	private AnswerRepository answerRepository;
	
/* Answer 테이블에 더미 데이터 입력 */ 
	/*
	@Test 
	public void insertAnswer() {
		Question q = new Question(); 
		Answer a = new Answer(); 
		
		//Question 객체 질문에대한 값을 가지고 와서 answer question필드에 넣어준다. 
		Optional<Question> op = 
				this.questionRepository.findById(2);
		q = op.get(); 
		
		
		a.setContent("1 글에대한 답변 입니다. - 2" );
		a.setCreateDate(LocalDateTime.now());
		a.setQuestion(q);
		
		this.answerRepository.save(a); 
	}
	*/
	 
	
	// question 테이블에 for 문을 사용해서 더미값 1000개 insert
	
	@Test
	public void insert1000() {
		Question q = null;
		
		// for문 사용해서 레코드 1000개 insert
		for(int i = 1; i <=1000; i++) {
			q = new Question();
			q.setSubject("제목 - " + i);
			q.setContent("내용 - " + i);
			q.setCreateDate(LocalDateTime.now());
			
			this.questionRepository.save(q);
		}
		
	}
	
	 /* */
	
	/* 하나의 질문에 여러 개의 답변 찾기 
	@Transactional	// 아래의 메소드가 하나의 트랜잭션으로 작동 되도록 설정 / JUnit test 시 오류나기 때문에 사용, 실제 운영환경에서는 문제 X
	@Test
	public void testjpa8() {
		
	// 1. Question 테이블에서 질문의 레코드를 얻어온다. 끄집어 낸다.
		Optional <Question> op =
			this.questionRepository.findById(1);
		
		Question q = null;
		
		if(op.isPresent()) {	// null이 아닐 때
			q = op.get();
		}
		// 2. 끄집어낸 객체의 q.getAnswerList();	<== 끄집어낸 객체의 답변글을 얻어온다.
		//Question 객체의 answerList 컬럼은 List<answer>
		List<Answer> all =	
					q.getAnswerList();
		
			
		// 3. 출력 구문에서 출력한다.
		for(int i = 0 ; i < all.size(); i++) {
			Answer a = all.get(i);
			System.out.println(a.getId());
			System.out.println(a.getContent());
			System.out.println(a.getCreateDate());
			System.out.println("================");
			
		}
		
		// 3-2. 향상된 for문 출력 구문
		
		for(Answer a2 : all ) {
			System.out.println(a2);
			System.out.println("================");
		}
		

	}
	
	*/
	/* 답변 레코드 하나 가져오기 
	@Test
	public void testjpa7() {
		Optional<Answer> op = 
		this.answerRopository.findById(2);
		
		if(op.isPresent()) {	//isPresent() : null(false), null이 아닐 때 (true)
			Answer a = op.get();
			System.out.println(a.getId());
			System.out.println(a.getContent());
			System.out.println(a.getCreateDate());
			System.out.println(a.getQuestion());
		}
	}
	
	*/
	
	/* Answer 테이블에 Insert 처리 
	@Test
	public void testAnswerjpa() {
		// 1. Quesition (부모) 테이블의 답변을 처리할 레코드를 먼저 select 한다. findById(1)
		Optional <Question> op =
					this.questionRepository.findById(1);
		Question q = op.get();
		// 2. Anwer 엔티티 테이블의 객체 생성을 하고, setter를 사용해서 값을 넣는다.
				// setQuestion(q)
		Answer a = new Answer();
		a.setQuestion(q);
		a.setContent("수정된 내용에 대한 답변입니다. 2");
		a.setCreateDate(LocalDateTime.now());	// 답변이 저장된 시간
		
		// 3. save 메서드를 사용해서 저장
		this.answerRopository.save(a);
		
	}
	
	*/
	
	/* 데이터 삭제 : delete() 
	@Test
	public void testjpa6() {
		// 1. 테이블에서 삭제할 레코드를 가지고 온다.
		Optional<Question> op = 
							this.questionRepository.findById(1);
		// 2. Optional 에 저장된 객체를 끄집어 낸다.
		Question q = op.get();
		
		// 3. delete(q)
		this.questionRepository.delete(q);
	}
	
	*/
	
	/* 데이터 수정 : save()  */
	
	/*
	@Test
	public void testjpa5() {
		// 1. 수정할 객체를 findById() 메소드를 사용해서 가지고 온다.
			Optional<Question> op =
					this.questionRepository.findById(1);
			
		// 2. 가지고 온 객체를 끄집어 내서 setter를 사용해서 수정
			Question q = op.get();
			q.setSubject("수정된 제목");
			q.setContent("수정된 내용");
			
		// 3. 수정된 객체를 save(q)
			this.questionRepository.save(q);
			
	}
	
	*/

	
	/*
	테이블의 모든 레코드 정렬 : asc , desc
	
	// Asc
	  
	@Test
	public void testjpa4() {
		List<Question> all = 
		this.questionRepository.findAllByOrderByCreateDateAsc();
		
		System.out.println("총 리스트에 있는 객체 수 : " + all.size());
		
		for(int i = 0; i < all.size() ; i++) {
			Question q = all.get(i);
			
			System.out.println(q.getId());
			System.out.println(q.getSubject());
			System.out.println(q.getContent());
			System.out.println(q.getCreateDate());
			System.out.println("======================");
			
		System.out.println("====== Desc 정렬 후 출력=====");	
		List<Question> all = 
		this.questionRepository.findAllByOrderByCreateDateDesc();
		
		System.out.println("총 리스트에 있는 객체 수 : " + all.size());
		
		for(int i = 0; i < all.size() ; i++) {
			Question q = all.get(i);
			
			System.out.println(q.getId());
			System.out.println(q.getSubject());
			System.out.println(q.getContent());
			System.out.println(q.getCreateDate());
			System.out.println("======================");
		}
	}
	
	*/
	
	
	
	
	/* 두 컬럼을 or 연산으로 검색 : subject, content 
	
	@Test
	public void testjpa4() {
		List<Question> all =
		this.questionRepository.findBySubjectLikeOrderByCreateDateAsc("%sbb%");

			for(int i = 0; i < all.size() ; i++) {
			Question q = all.get(i);
			
			System.out.println(q.getId());
			System.out.println(q.getSubject());
			System.out.println(q.getContent());
			System.out.println(q.getCreateDate());
			System.out.println("======================");

		}
	}
		*/
		
		

	
	/*
	@Test
	public void testjpa3() {
		List<Question> or =
		this.questionRepository.findByOrderByCreateDateAsc();
		
		Question q = or.get(0);
	
		System.out.println(q.getId());
		System.out.println(q.getSubject());
		System.out.println(q.getContent());
		System.out.println(q.getCreateDate());
		
		System.out.println("======================");

	
	*/
	
	
	
	/*
	@Test
	public void testjps2() {
		List<Question> sq = this.questionRepository.findBySubjectLikeOrContentLike("%sbb%", "%id%");
		
		// Question q = all.get(1);
		
		System.out.println(" 총 검색된 개수 : " + sq.size());
		
		Question q4 = sq.get(0);
		
			System.out.println(q4.getId());
			System.out.println(q4.getSubject());
			System.out.println(q4.getContent());

	}
	
	*/
	
	/* 사용자 정의 select 문 : subject 컬럼 , content 컬럼, Like
	@Test
	public void testjpa() {
		
		List<Question> all = this.questionRepository.findBySubjectLike("%sbb%");
		
		Question q = all.get(0);
		
		System.out.println("q1 리스트에 검색된 레코드 수 : " + all.size());
		System.out.println(q.getId());
		System.out.println(q.getSubject());
		System.out.println(q.getContent());
		
		System.out.println("==============================");
		
		List<Question> all2 = this.questionRepository.findByContentLike("%자동%");
		
		Question q2 = all2.get(0);
		System.out.println("q2 리스트에 검색된 레코드 수 : " + all2.size());
		System.out.println(q2.getId());
		System.out.println(q2.getSubject());
		System.out.println(q2.getContent());
		
	}
	
	*/
	
	
	
	
	/* 조건에 맞는 레코드 하나만 가져 오기 : PK 컬럼은 findById(1)
	 * question 테이블의 Primary Key 컬럼은 기본적으로 제공됨 : findById()
	 * 
	 * 
	 
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
	
	*/

	
	/* Select List JUnit Test , JPA 인터페이스에 정의 된 save()
	
	@Test
	public void jpaTest() {
		List<Question> all = this.questionRepository.findAll();
		//assertEquals(2, all.size());	// assertEquals(기대값, 실제값), 성공(두 값이 일치)
		
		Question q = all.get(0);	//List all 변수에 담긴 0번 방의 Question 객체를 끄집어
		// assertEquals("sbb가 무엇인가요", q.getSubject());	// 성공
		
		System.out.println("Id 값 : " + q.getId());
		System.out.println("제목 : " + q.getSubject());
		System.out.println("내용 : " + q.getContent());
	}
	*/
	
	 
	
	
	// findall : 모든 레코드를 DB 값을 가져온다.
	//  DB에서 값을 가져와서 setter주입으로 모든 객체를 List에 저장.

/* Insert JUnit Test , JPA 인터페이스에 정의 된 save()
 // 추상화
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
