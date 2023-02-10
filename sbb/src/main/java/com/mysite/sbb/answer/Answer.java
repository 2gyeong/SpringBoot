package com.mysite.sbb.answer;

import java.time.LocalDateTime;

import com.mysite.sbb.question.Question;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter		// LomBok 라이브러리
@Setter		// LomBok 라이브러리
@Entity		// JPA에서 자바 객체를 DB의 테이블에 매핑
public class Answer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;		//Primary Key, 자동 증가됨.(1,1)
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	private LocalDateTime createDate;
					
					// 중요 !!
	@ManyToOne		// Foreign Key	: 부모테이블의 PK, UK컬럼의 값을 참조해서 값을 할당.
	private Question question;		// 중요!! question 컬럼 
								// 부모 테이블이 Question 테이블의 Primary Key를 참조 (id)
						
}
