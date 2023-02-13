package com.mysite.sbb2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class TestController {
		
	@GetMapping("/text")
	@ResponseBody
		public String text() {
			
			return "Test 코드 블락입니다.";
		}
	}

