package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/index")		//http://localhost:9292
	public String index() {
		
		return "index"; 
	}

}