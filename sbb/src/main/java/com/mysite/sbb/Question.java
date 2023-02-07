package com.mysite.sbb;

import java.time.LocalDateTime;		// 자신의 시스템의 local 시간
import java.util.List;

import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Column;
//persistence : JPA에서 사용된 어노테이션
import jakarta.persistence.Entity;		// JPA 에서 적용된 어노테이션
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity		// 자바 클래스를 DB의 테이블과 매핑된 클래스		: 테이블명 : question
public class Question {		
	
	@Id		//Primary Key
	@GeneratedValue	(strategy = GenerationType.IDENTITY) // 시퀀스 할당
	private Integer id;		// Primary Key, 시퀀스(1, 1)
	
	@Column(length = 200)	// 200자 까지 
	private String subject;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	private LocalDateTime createDate;	// create_data : 
	
	/*
	@Column (length = 300)
	private String addr;
	*/
	
	// Question 테이블에서 Answer테이블을 참조하는 컬럼을 생성 @OnetoMany
	
	@OneToMany (mappedBy = "question", cascade = jakarta.persistence.CascadeType.REMOVE )
	private List<Answer> answerList;
	
		// question.getAnswerList();
}
