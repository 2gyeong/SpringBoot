package com.mysite.member;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberFormDto {
	
	private Integer id;
	
	@NotBlank(message="이름을 입력 하세요.")
	private String mName;
	
	@NotBlank(message="비밀번호를 입력 하세요.")
	private String mPassword;
	
	private String mPasswordConf;
	
	@NotBlank(message="이메일을 입력 하세요.")
	private String email;
	
	private String addr;
	
}
