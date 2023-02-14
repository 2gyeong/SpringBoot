package com.mysite.sbb2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
	
	@GetMapping("/")		//http://localhost:9292
	public String index() {
		
		return "redirect:/users/list"; 
	}

}