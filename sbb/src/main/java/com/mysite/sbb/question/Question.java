package com.mysite.sbb.question;

import java.time.LocalDateTime;		// 자신의 시스템의 local 시간
import java.util.List;
import java.util.Set;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.user.SiteUser;

import jakarta.persistence.Column;
//persistence : JPA에서 사용된 어노테이션
import jakarta.persistence.Entity;		// JPA 에서 적용된 어노테이션
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Entity		// 자바 클래스를 DB의 테이블과 매핑된 클래스		: 테이블명 : question
public class Question {		
	
	@Id		//Primary Key
	@GeneratedValue	(strategy = GenerationType.IDENTITY) // 시퀀스 할당
	private Integer id;		// Primary Key, 시퀀스(1, 1)
	
	@Column(length = 200)	// 200자 까지 
	private String subject;
	
	
	//@Column(columnDefinition = "TEXT")
	@Column(length = 4000)
	private String content;
	private LocalDateTime createDate;	// create_data : 
	
	/*
	@Column (length = 300)
	private String addr;
	*/
	
	// Question 테이블에서 Answer테이블을 참조하는 컬럼을 생성 @OnetoMany
	// 하나의 질문에 있는 여러 개의 답변을 리스트를 저장. 하나의 질문에 대해 여러 개의 답변을 gettering 해서 가져온다.(연결)  
	@OneToMany (mappedBy = "question", cascade = jakarta.persistence.CascadeType.REMOVE )
	private List<Answer> answerList;
	
		// question.getAnswerList();
	
	// 엔티티 추가 - 글 작성자(글쓴이)에 해당하는 author속성 추가
	@ManyToOne
	private SiteUser author;
	
	// 수정 일시
	private LocalDateTime modifyDate;
	
	// 추천
	// List : 바으이 번호(Index)를 가지고 중복된 값을 저장할 수 있다.
	// set -> 중복 허용 안 함, 방번호를 가지지 않는다.
	@ManyToMany		// 1. 한 명의 사용자가 여러 질문에 투표할 수 있다. 2. 하나의 질문에 여러 명의 사용자가 투표할 수 있다. 
	Set<SiteUser> voter;
}
