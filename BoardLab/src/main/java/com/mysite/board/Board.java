package com.mysite.board;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import com.mysite.member.Member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Board {

	@Id
	@Column(name="board_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String subject;
	
	private String content;
	
	@CreatedDate
	private LocalDateTime createDate;
	
	
	private LocalDateTime modifyDate;
	
	@ManyToOne
	private Member author;
}
