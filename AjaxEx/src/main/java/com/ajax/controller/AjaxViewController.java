package com.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AjaxViewController {

	@GetMapping("/ajax-ex-01")
	public String ajaxex01 () {
		
		System.out.println("AjaxController ex01 요청 성공");
		
		return "ajax-ex-01";	
	}
	
	@GetMapping("/ajax-ex-02")
	public String ajaxex02() {
		
		System.out.println("AjaxController ex01 요청 성공");
		
		return "ajax-ex-02";	
	}
	
	@GetMapping("/ajax-ex-03")
	public String ajaxex03() {
		
		System.out.println("AjaxController ex03 요청 성공");
		
		return "ajax-ex-03";	
	}
	
	@GetMapping("/ajax-ex-04")
	public String ajaxex04() {
		System.out.println("AjaxController ex04 요청 성공");
		return "ajax-ex-04";	
	}
	
	@GetMapping("/ajax-ex-05")
	public String ajaxex05() {
		System.out.println("AjaxController ex05 요청 성공");
		return "ajax-ex-05";	
	}
	
	@GetMapping("/ajax-ex-06")
	public String ajaxex06() {
		System.out.println("AjaxController ex06 요청 성공");
		return "ajax-ex-06";	
	}
	
	@GetMapping("/ajax-ex-07")
	public String ajaxex07() {
		System.out.println("AjaxController ex07 요청 성공");
		return "ajax-ex-07";	
	}
	
	@GetMapping("/ajax-ex-08")
	public String ajaxex08() {
		System.out.println("AjaxController ex08 요청 성공");
		return "ajax-ex-08";	
	}
	
	@GetMapping("/ajax-ex-09")
	public String ajaxex09() {
		System.out.println("AjaxController ex09 요청 성공");
		return "ajax-ex-09";	
	}
	
	@GetMapping("/ajax-ex-10")
	public String ajaxex10() {
		System.out.println("AjaxController ex10 요청 성공");
		return "ajax-ex-10";	
	}
}
