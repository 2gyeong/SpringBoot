package com.mysite.sbb2;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Entity
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //기본 키 생성을 데이터베이스에 위임
	private Integer idx;
	
	@Column(length =100)
	private String name;
	@Column(length =100)
	private String pass;
	@Column(length =100)
	private String email;
	
	private LocalDateTime regdate;
	
	private Integer cnt;
	
}
