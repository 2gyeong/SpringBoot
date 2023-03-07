package com.washour.www.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

	@GetMapping("/login")
	public String login() {
		
		return "login";
	}
}
