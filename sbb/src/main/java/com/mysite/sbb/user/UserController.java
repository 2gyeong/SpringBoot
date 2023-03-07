package com.mysite.sbb.user;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {
	private final UserService userService;
	
	// 회원가입
	// 회원가입 View 페이지
	@GetMapping("/signup")
	public String signup(UserCreateForm userCreateForm) {
		
		return "signup_form";
	}
	// 회원가입 form에서 넘어오는 post
	@PostMapping("/signup")
								//userCreateForm에 에러 정보가 들어 있다.
	public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {		// 에러가 있으면
			return "signup_form";			// signup_form.html을 다시 연다.
		}
		// password1과 password2(비밀번호 확인)이 일치하는 지 확인
		if(!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())) {
			bindingResult.rejectValue("password2", "passwordInCorrect", "2개의 패스워드가 일치하지 않습니다.");
			return "signup_form";
		}
		
		// 에러가 없고, 비밀번호가 일치하면 진행 
		try {		// service - create 저장 메소드
		userService.create(userCreateForm.getUsername(), 
				userCreateForm.getEmail(), userCreateForm.getPassword1());
		
		} catch(DataIntegrityViolationException e) {
			// ID 중복일 경우 (unique key)
			e.printStackTrace();
			bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
			return "signup_form";
			
		} catch (Exception e){
			e.printStackTrace();
			bindingResult.reject("signupFailed",e.getMessage());
			return "signup_form";
		} 
		return "redirect:/";
	}
	
	// 로그인
	@GetMapping("/login")
	public String login() {
		return "login_form";
	}
}
