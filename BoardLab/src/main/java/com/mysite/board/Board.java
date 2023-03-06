package com.mysite.board;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.repository.Modifying;

import com.mysite.member.Member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int boardId;
	
	@Column(columnDefinition = "TEXT")
	private String subject;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	@CreatedDate
	private LocalDateTime createDate;
	
	
	private LocalDateTime modifyDate;
	
	
	@ManyToOne
	private Member member;
}
