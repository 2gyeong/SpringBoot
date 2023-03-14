package com.washour.www.answer;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.washour.www.member.Member;
import com.washour.www.member.MemberService;
import com.washour.www.qeustion.Question;
import com.washour.www.qeustion.QuestionService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {

	 private final QuestionService questionService;
	 private final AnswerService answerService;
	 private final MemberService memberService;

	 @PreAuthorize("isAuthenticated()")
	 @PostMapping("/create/{id}")
	    public String createAnswer(Model model, @PathVariable("id") Integer id, 
	    		@Valid AnswerForm answerForm, BindingResult bindingResult, Principal principal) {
	        Question question = this.questionService.getQuestion(id);
	        Member member = this.memberService.getMember(principal.getName());
	        if (bindingResult.hasErrors()) {
	            model.addAttribute("question", question);
	            return "question_detail";
	        }
	        this.answerService.create(question, answerForm.getContent(), member);
	        return String.format("redirect:/question/detail/%s", id);
	    }
}