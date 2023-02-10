package com.mysite.sbb2.users;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UsersController {
	
	public final UsersService usersService;
	
	@GetMapping("/users/list")
	@PostMapping("/users/list")
	public String list (Model model) {
			List<Users> usersList = this.usersService.getList();
			
			model.addAttribute("usersList", usersList);
	
	 return "users_list";
	}
	
	// 상세 페이지
	@GetMapping(value = "/users/detail/{idx}")
	public String detail (Model model, @PathVariable("idx") Integer idx) {
		
		Users u = this.usersService.getUsers(idx);
		
		model.addAttribute("users", u);
		
		return "users_detail";
	}
	
}
