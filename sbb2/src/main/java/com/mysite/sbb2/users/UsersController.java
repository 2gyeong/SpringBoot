package com.mysite.sbb2.users;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.sbb2.DataNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UsersController {
	
	private final UsersRepository usersRepository;
	public final UsersService usersService;
	

	@GetMapping("/users/list")
	public String usersList(Model model,
			@RequestParam(value="page", defaultValue = "0") int page) {
		Page<Users> usersList = this.usersService.getList(page);
		model.addAttribute("usersList", usersList);
		return "users_list";
	}
	
	// 상세 페이지
	@GetMapping(value = "/users_detail/{idx}")
	public String detail (Model model, @PathVariable("idx") Integer idx) throws DataNotFoundException {
		
		Users u = this.usersService.getUsers(idx);
		
		model.addAttribute("users", u);
		
		return "user_detail";
	}
	
	// insert 
	@GetMapping("/user_insert")
	public String insert () {
		return "user_insert";
	}
	
	// 등록
	@PostMapping("/insert_save")
	public String insertSave(@RequestParam String name, @RequestParam String pass, @RequestParam String email) {
		this.usersService.insertSave(name, pass, email);
		return "redirect:/users/list";
	}
	
}
