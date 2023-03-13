package com.washour.www.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {
	
	@GetMapping("/")		
	public String index() {
		
		return "index"; 
	}
	
	@GetMapping("/category_1")
	public String category() {
		
		return "category/category_1";
	}
	


}