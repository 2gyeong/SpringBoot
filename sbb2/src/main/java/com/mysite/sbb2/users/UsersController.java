package com.mysite.sbb2.users;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.sbb2.DataNotFoundException;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UsersController {
	
	private final UsersRepository usersRepository;
	public final UsersService usersService;
	

	@GetMapping("/users/list")
	public String usersList(Model model,
			@RequestParam(value="page", defaultValue = "0") int page) {
		Page<Users> paging = this.usersService.getList(page);
		model.addAttribute("paging", paging);
		return "users_list";
	}
	
	// 상세 페이지
	@GetMapping(value = "/users_detail/{idx}")
	public String detail (Model model, @PathVariable("idx") Integer idx) throws DataNotFoundException {
		
		Users u = this.usersService.getUsers(idx);
		
		model.addAttribute("users", u);
		
		return "users_detail";
	}
	
	// insert // save
	@GetMapping("/user_insert")
	public String userInsert (UserInsert userInsert) {
		return "user_insert";
	}
	
	@PostMapping("/user_insert")
	public String userInsert (@Valid UserInsert userInsert, BindingResult bindingResult ) {
		if(bindingResult.hasErrors()) {
			return "user_insert";
		}
		
		this.usersService.insertSave(userInsert.getName(), userInsert.getPass(), userInsert.getEmail());
		
		return "redirect:/users/list";
		
	}
	
	
}
