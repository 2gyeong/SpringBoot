package com.mysite.sbb.question;

import com.mysite.sbb.user.SiteUser;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mysite.sbb.DataNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // DI(생성자에 객체 주입)
@Service
public class QuestionService {
	// JPA 메소드를 사용하기 위해
	private final QuestionRepository questionRepository;
	
	// 메소드 : question 테이블의 List 정보를 가지고 오는 메소드
	/*
	 * public List<Question> getList(){ return this.questionRepository.findAll(); }
	 */
	
	// 페이징 처리
	//Controller에서 getList메소드 호출 시 출력할 page 번호를 매개변수로 받음 : 0, 1, 2, 3
	public Page<Question> getList(int page){
		
		//sort를 사용해서 번호를 정렬해서 가지고 오기
		
		// 최신글을 먼저 출력하기, 날짜 컬럼 (createDate)을 desc해서 출력
		List<Sort.Order> sorts = new ArrayList<>();
		sorts.add(Sort.Order.desc("createDate"));
		
		//Pageable 객체에 2개의 값을 담아서 매개변수로 던짐, 10 <== 출력할 레코드 수
		Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
		
		return this.questionRepository.findAll(pageable);
	}

	//상세 페이지를 처리 하는 메소드 : id를 받아서 Question 테이블을 select (findById(1)
			//해서 select 한 레코드를 Question 객체에 담아서 리턴 
		 public Question getQuestion(Integer id) {
			
			//select * from question where id = ?
			Optional<Question> op = this.questionRepository.findById(id) ; 
			if ( op.isPresent()) {	//op 에 값이 존재하는 경우 
				return op.get();  // Question 객체를 리턴 
			}else {
				//사용자 정의 예외 : 
				//throw : 예외를 강제로 발생 
				//throws : 예외를 요청한 곳에서 처리하도록 미루는 것 
				throw new DataNotFoundException("요청한 파일을 찾지 못했습니다. "); 
			}
		}
		
	 // 질문 등록 처리 메소드
		public void create(String subject, String content, SiteUser user) {
			// Question 객체를 생성 후 Setter 주입
			Question q = new Question();
			q.setSubject(subject);
			q.setContent(content);
			q.setCreateDate(LocalDateTime.now());
			q.setAuthor(user);
			
			// repository의 save() 메소드에 question 객체 저장
			this.questionRepository.save(q);	// db에 insert
		}
		
	// 수정
		public void modify(Question question, String subject, String content) {
			question.setSubject(subject);
			question.setContent(content);
			question.setModifyDayte(LocalDateTime.now());
			this.questionRepository.save(question);
		}
	
	// 질문 삭제
		public void delete(Question question) {
			this.questionRepository.delete(question);
		}
}
