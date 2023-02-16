package com.mysite.sbb.answer;

import java.security.Principal;
import com.mysite.sbb.user.UserService;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionService;
import com.mysite.sbb.user.SiteUser;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {
	
	private final QuestionService questionService;
	private final AnswerService answerService; 
	private final UserService userService;
	
	//http://localhost:9292/answer/create/1 요청에 대한 답변글 등록 처리 
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/create/{id}")
	public String createAnswer(
			// << Validation 전 구성 >>
			//Model model, @PathVariable("id") Integer id, @RequestParam String content 
			
			// content의 유효성 검사
			// Principal : 현재 로그인한 사용자의 정보에 대한 객체 
			Model model, @PathVariable("id") Integer id, 
			@Valid AnswerForm answerForm, BindingResult bindingResult, Principal principal
			) {
		
		Question question = this.questionService.getQuestion(id); 
												//principal.getName() : 사용자명
		SiteUser siteUser = this.userService.getUser(principal.getName());
		
		//답변 내용을 저장하는 메소드 호출 (Service에서 호출) 
				// content의 값이 비어있을 때
				if(bindingResult.hasErrors()) {
					model.addAttribute("question", question);
					return "question_detail";
				}
		
		this.answerService.create(question, answerForm.getContent(), siteUser);
		
		return String.format("redirect:/question/detail/%s", id); 
	}
	


}