package com.washour.www.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

	@GetMapping(value = "/login")
	public String login() {
		
		return "/member/login";
	}
	
	@GetMapping("/sign_up")
	public String signUpForm (Model model) {
		model.addAttribute(new SignUpForm());
		return "/member/signUp_Form";
	}
	
	//public String signUpSubmit() {}
}
