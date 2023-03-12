package com.washour.www.member;

import javax.validation.Valid;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(value = "/member")
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberService memberService;

	@GetMapping(value = "/login")
	public String login() {
		
		return "member/login";
	}
	
	
	
	@GetMapping("/sign_up")
	public String signUp (SignUpForm signUpForm) {
		return "member/signUp_Form";
	}
	
	@PostMapping("/sign_up")
	public String signUp (@Valid SignUpForm signUpForm, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "member/signUp_Form";
		}
		
		if(!signUpForm.getPassword1().equals(signUpForm.getPassword2())) {
			bindingResult.rejectValue("password2", "passwordInCorrect", 
					"패스워드가 일치하지 않습니다.");
			
			return "member/signup_Form";
		}
		
		try {
			memberService.signUp(signUpForm.getUsername(), 
				signUpForm.getEmail(), signUpForm.getPassword1(), signUpForm.getAddress());
		} catch(DataIntegrityViolationException e) {
			e.printStackTrace();
			bindingResult.reject("signupFailed", "이미 사용중인 ID입니다.");
			return "member/signup_Form";
			
		} catch(Exception e) {
			e.printStackTrace();
			bindingResult.reject("signupFailed", e.getMessage());
			
			return "redirect:/";
		}
		
		
		return "redirect:/member/login";
			
	}
}
