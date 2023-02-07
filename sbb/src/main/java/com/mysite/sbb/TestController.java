package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	@GetMapping("/test") // "/test" 요청이 오면
	@ResponseBody	// 클라이언트가 요청하는 브라우저에 값을 돌려주겠다.
	public String text() {
		
		return "Test 코드 블락입니다. " ;
	}
}
