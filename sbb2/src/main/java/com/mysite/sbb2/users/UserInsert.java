package com.mysite.sbb2.users;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInsert {
	
	@NotEmpty(message="이름은 필수 사항입니다.")
	@Size(max=100)
	private String name;
	@NotEmpty(message="비밀번호는 필수 사항입니다.")
	@Size(max=100)
	private String pass;
	@NotEmpty(message="이메일은 필수 사항입니다.")
	@Size(max=200)
	private String email;
}
