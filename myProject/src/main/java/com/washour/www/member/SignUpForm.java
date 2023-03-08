package com.washour.www.member;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignUpForm {
	
	@Size(min=3, max=25, message="ID는 3~25자 이내로 작성해주세요.")
	@NotEmpty(message="사용자 ID는 필수 항목입니다.")
	private String memberId;
	@NotEmpty(message="비밀번호는 필수 항목입니다.")
	private String password1;
	
	@NotEmpty(message="비밀번호 확인은 필수 항목입니다.")
	private String password2;
	
	@NotEmpty(message="이름은 필수 항목입니다.")
	private String name;
	
	@NotEmpty(message="이메일은 필수 항목입니다.")
	@Email
	private String email;
	
	@NotEmpty(message="주소는 필수 항목입니다.")
	private String address;
}
