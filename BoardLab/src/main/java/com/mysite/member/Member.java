package com.mysite.member;

import groovy.transform.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int memberId;
	
	private String mName;
	
	private String mPassword;
	
	@Column(unique = true)
	private String email;
	
	private String addr;
	
}
