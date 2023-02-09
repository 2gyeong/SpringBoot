package com.mysite.sbb.question;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mysite.sbb.Question;
import com.mysite.sbb.QuestionRepository;

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
	private final QuestionRepository questionrepository;
	
	  
	@GetMapping("/question/list")	// http://localhost:9292/question/list
	@PostMapping("/question/list") // Form 태그의 method=post action ="/question/list"
	//@ResponseBody			// 요청을 브라우저에 출력
	//@ResponseBody이 없으면 view 페이지(.html)를 찾음
	public String list(Model model) {
		// 1. 클라이언트 요청 정보; http://localhost:9292/question/list
		
		// 2. 비즈니스 로직을 처리 
		List<Question> questionList = 
				this.questionrepository.findAll();
		
		// 3. 뷰(View) 페이지로 전송
			// Model : 뷰페이지로 서버의 데이터를 담아서 전송 객체 (Session, Application)
		model.addAttribute("questionList", questionList);
		
		return "question_list";
	}
}
