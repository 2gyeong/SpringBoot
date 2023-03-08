package com.washour.www.member;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Data
@Table(name="member")
public class Member {
		@Id
	    @Column(name="member_idx")
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long idx;
		
		@Column(unique = true)
		private String id;

	    private String username;

	    @Column(unique = true)
	    private String email;

	    private String password;

	    private String address;


	
}
