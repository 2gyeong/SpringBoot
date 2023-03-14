package com.washour.www.qeustion;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.washour.www.answer.AnswerForm;
import com.washour.www.answer.AnswerService;
import com.washour.www.member.Member;
import com.washour.www.member.MemberService;

import lombok.RequiredArgsConstructor;

@RequestMapping(value = "/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {
	
	private final QuestionService questionService;
	private final MemberService memberService;

	@GetMapping("/list")
	public String list(Model model) {
		List<Question> questionList = this.questionService.getList();
        model.addAttribute("questionList", questionList);
        return "question_list";
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/create")
    public String questionCreate(QuestionForm questionForm) {
        return "question_form";
    }

	@PreAuthorize("isAuthenticated()")
	@PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult
    		, Principal principal) {
        if (bindingResult.hasErrors()) {
            return "question_form";
        }
        Member member = this.memberService.getMember(principal.getName());
        this.questionService.create(questionForm.getSubject(), questionForm.getContent(), member);
        return "redirect:/question/list";
    }
	
	@GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
		Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }
	
	
}
