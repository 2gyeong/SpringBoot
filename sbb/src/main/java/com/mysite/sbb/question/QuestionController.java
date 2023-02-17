package com.mysite.sbb.question;

import java.security.Principal;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.mysite.sbb.answer.AnswerForm;
import com.mysite.sbb.user.SiteUser;
import com.mysite.sbb.user.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // final 필드의 생성자를 자동으로 만들어서 생성자를 통한 의존성 주입
@Controller
public class QuestionController {
	/* 클래스를 객체로 생성 어노테이션 
	 * 	@Component : 일반적인 클래스를 객체화
	 * 	@Controller : 클라이언트 요청을 받아서 처리 , Controller
	 * 		1. 클라이언트 요청을 받는다. @GetMapping, @PostMapping
	 * 		2. 비즈니스 로직 처리, Service의 메소드 호출
	 * 		3. View 페이지로 응답
	 * 
	 * 	@Service : DAO의 메소드를 구현한 클래스
	 * 		- 유지 보수를 쉽게 하기 위해서 (약결합)
	 * 	@Repository : DAO 클래스를 빈등록
	 * 	
	 * DI (의존성 주입)
	 * 1. @Autowired : spring Framework의 생성된 빈(객체)을 주입, 타입을 찾아서 주입
	 * 	같은 타입의 객체가 존재할 경우 문제가 발생할 수 있다. 
	 * 2. 생성자를 통한 의존성 주입 (권장사항)
	 * 3. Setter 를 사용한 의존성 주입
	 * 
	 * 
	 * */
	
	// 생성자를 통한 의존성 주입 <== 권장하는 방식
		// Controller 에서 직접 Repository 를 접근하지 않고 Service를 접근하도록 함.
	//private final QuestionRepository questionrepository;
	private final QuestionService questionService;
	
	private final UserService userService;

	/*
	@GetMapping("/question/list")	// http://localhost:9292/question/list
	@PostMapping("/question/list") // Form 태그의 method=post action ="/question/list"
	//@ResponseBody			// 요청을 브라우저에 출력
	//@ResponseBody이 없으면 view 페이지(.html)를 찾음
	public String list(Model model) {
		// 1. 클라이언트 요청 정보; http://localhost:9292/question/list
		
		// 2. 비즈니스 로직을 처리 
		List<Question> questionList = 
			//	this.questionrepository.findAll();
			this.questionService.getList();
		// 3. 뷰(View) 페이지로 전송
			// Model : 뷰페이지로 서버의 데이터를 담아서 전송 객체 (Session, Application)
		model.addAttribute("questionList", questionList);
		
		return "question_list"; 
	}
	
	*/
	
	// 2월 14일 페이징 처리를 위해 수정됨
	@GetMapping("/question/list")
	public String list(Model model, @RequestParam(value="page", defaultValue="0") int page,
			@RequestParam(value="kw", defaultValue = "") String kw) {
		// 비즈니스 로직 처리 : 
		Page<Question> paging = 
						this.questionService.getList(page, kw);
		
		// model 객체에 결과로 받은 paging 객체를 client로 전송
		model.addAttribute("paging", paging);
		model.addAttribute("kw", kw);
		
		return "question_list";
	}
	
	// 상세 페이지를 처리하는 메소드 : /question/detail/1
		@GetMapping(value = "/question/detail/{id}")
		public String detail (Model model , @PathVariable("id") Integer id, AnswerForm answerForm) {
			// 서비스 클래스의 메소드 호출 : 상세페이지 보여 달라 
			Question q = 
					this.questionService.getQuestion(id); 
			
			// Model 객체에 결과로 받은 paging 객체를 클라이언트로 전송 
			model.addAttribute("question", q); 
			
			return "question_detail";   //template  : question_detail.html
		}
		
	// 질문 등록 Question_form
		@PreAuthorize("isAuthenticated()")
		@GetMapping("/question/create")
		public String questionCreate(QuestionForm questionForm) {
			return "question_form";
		}
		@PreAuthorize("isAuthenticated()")
		@PostMapping("/question/create")
		public String questionCreate(
				//@RequestParam String subject,@RequestParam String content) {
				@Valid QuestionForm questionForm, BindingResult bindingResult, Principal principal ) {
			
				if(bindingResult.hasErrors()) {	// subject, content가 비었을 때
					return "question_form";
				}

			// 로그인 사용자 확인하기
			//	System.out.println("현재 로그인한 사용자 : " + principal);
				
				
			SiteUser siteUser = this.userService.getUser(principal.getName());
			// 로직 작성부분 (service 에서 로직을 만들어서 작동)
		//	this.questionService.create(subject, content);
				this.questionService.create(questionForm.getSubject(), questionForm.getContent(), siteUser);
			// 값을 DB에 저장 후 List페이지로 리다이렉트 (질문 목록으로 이동)
			
				return "redirect:/question/list";
		}
		
		@PreAuthorize("isAuthenticated()")
	    @GetMapping("/question/modify/{id}")
	    public String questionModify(QuestionForm questionForm, @PathVariable("id") Integer id, Principal principal) {
	        Question question = this.questionService.getQuestion(id);
	        if(!question.getAuthor().getUsername().equals(principal.getName())) {
	            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
	        }
	        questionForm.setSubject(question.getSubject());
	        questionForm.setContent(question.getContent());
	        return "question_form";
	    }
	
		// 수정 메소드
		@PreAuthorize("isAuthenticated()")	// 실행하기 전에 권한을 검사하는 어노테이션
		@PostMapping("/question/modify/{id}")
		public String questionModify(@Valid QuestionForm questionForm, BindingResult bindingResult,
				@PathVariable("id") Integer id, Principal principal) {
			
			if(bindingResult.hasErrors()) {
				return "question_form";
			}
			Question question = this.questionService.getQuestion(id);
			
			// 작성자가 동일하지 않을 경우 오류 발생
			if(!question.getAuthor().getUsername().equals(principal.getName())) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
			}
			this.questionService.modify(question, questionForm.getSubject(), questionForm.getContent());
			
			return String.format("redirect:/question/detail/%s", id);
		}
		
		// 삭제
		 @PreAuthorize("isAuthenticated()")		// 실행하기 전에 권한을 검사하는 어노테이션
		 @GetMapping("/question/delete/{id}")
		public String questionDelete(Principal principal, @PathVariable("id") Integer id) {
			Question question = this.questionService.getQuestion(id);
			if(!question.getAuthor().getUsername().equals(principal.getName())) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제 권한이 없습니다.");
			}
			this.questionService.delete(question);
			return "redirect:/question/list";
		}
		 
		// 추천
		@PreAuthorize("isAuthenticated()")
		@GetMapping("/question/vote/{id}")
		public String questionVote(Principal principal, @PathVariable("id") Integer id) {
			Question question = this.questionService.getQuestion(id);
			SiteUser siteUser = this.userService.getUser(principal.getName());
			this.questionService.vote(question, siteUser);
			return String.format("redirect:/question/detail/%s", id);
		}
}
