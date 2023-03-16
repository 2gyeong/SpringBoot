package com.ajax.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ajax.dto.AjaxDTO;
import com.ajax.dto.AjaxLabDTO;
import com.ajax.dto.MovieDTO;
import com.ajax.service.MovieService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AjaxController {
	
	private final MovieService movieService ;
	
	@GetMapping("/ex01")
	public String ex01 () {
		
		System.out.println("AjaxController ex01 요청 성공");
		
		return "index";	// index.html 에 작성된 내용이 그대로 출력됨. <index.html>의 소스코드가 전송
	}
	
	@PostMapping("/ex02")
	public @ResponseBody String ex02 () {
		
		System.out.println("AjaxController ex02 요청 성공");
		
		return "안녕하세요";	// 리턴에 문자열을 그대로 전송하기 위해서는 @ResponseBody 어노테이션을 적용
	}
	
	
	@GetMapping("/ex03")	// ajax에서 param1, param2를 넘겨준다. 
	public @ResponseBody String ex03(@RequestParam("param1") String param1, 
			@RequestParam("param2") String param2) {
		
		System.out.println("AjaxController ex03 요청 성공");
		System.out.println("param1 :" + param1);
		System.out.println("param2 :" + param2);
		
		return "ex03 처리완료";	
	}
	
	@PostMapping("/ex04")	// ajax에서 param1, param2를 넘겨준다. 
	public @ResponseBody String ex04(@RequestParam("param1") String param1, 
			@RequestParam("param2") String param2) {
		
		System.out.println("AjaxController ex04 요청 성공");
		System.out.println("param1 :" + param1 +", param2 :" + param2);
		
		return "ex04 처리완료";	
	}
	
	@GetMapping("/ex05")	// ajax에서 param1, param2를 넘겨준다. 
							// @ModelAttribute : 클라이언트에서 넘긴 파라미터를 DTO에 저장 (생략)
							// 리턴을 DTO 객체 return 
	public @ResponseBody AjaxDTO ex05(@ModelAttribute AjaxDTO ajaxDTO) {
		
		System.out.println("AjaxController ex05 요청 성공");
		System.out.println("param :" + ajaxDTO);
		
		// BackEnd DB의 로직을 처리 후 DB의 레코드 하나를 DTO 객체에 저장 후 리턴
		return ajaxDTO;	
	}
	
	@PostMapping("/ex06")	// ajax에서 param1, param2를 넘겨준다. 
	// @ModelAttribute : 클라이언트에서 넘긴 파라미터를 DTO에 저장 (생략)
	// 리턴을 DTO 객체 return 
	public @ResponseBody AjaxDTO ex06(@ModelAttribute AjaxDTO ajaxDTO) {
	
	System.out.println("AjaxController ex06 요청 성공");
	System.out.println("param :" + ajaxDTO);
	
	// BackEnd DB의 로직을 처리 후 DB의 레코드 하나를 DTO 객체에 저장 후 리턴
	return ajaxDTO;	
	}
	
	@PostMapping("/ex07")	// ajax에서 param1, param2를 넘겨준다. 
							// @RequestBody 로 클라이언트가 넘긴 파라미터 JSON형식이다라고 
							// 리턴을 DTO 객체 return 
	public @ResponseBody AjaxDTO ex07(@RequestBody AjaxDTO ajaxDTO) {
	
	System.out.println("AjaxController ex07 요청 성공");
	System.out.println("param :" + ajaxDTO);
	
	// BackEnd DB의 로직을 처리 후 DB의 레코드 하나를 DTO 객체에 저장 후 리턴
	return ajaxDTO;	
	}
	
	@PostMapping("/ex08")	// ajax에서 param1, param2를 넘겨준다. 
							// @RequestBody 로 클라이언트가 넘긴 파라미터 JSON형식이다라고 
							// 리턴을 LIST<DTO> 객체를 return 
	public @ResponseBody List<AjaxDTO> ex08(@RequestBody AjaxDTO ajaxDTO) {
	
	System.out.println("AjaxController ex08 요청 성공");
	System.out.println("param :" + ajaxDTO);
	
	// BackEnd DB의 로직을 처리 후 DB의 레코드 하나를 List<DTO> 객체에 저장 후 리턴
	List<AjaxDTO> dtoList = new ArrayList();
	dtoList.add(ajaxDTO); 				// index 0
	dtoList.add(new AjaxDTO("data1", "data2"));		// index1
	dtoList.add(new AjaxDTO("data11", "data22"));	// index2
	
	return dtoList;	
	}
	
	@PostMapping("/ex09")	// ajax에서 param1, param2를 넘겨준다. 
	// @RequestBody 로 클라이언트가 넘긴 파라미터 JSON형식이다라고 
	// 리턴을 ResposeEntity 객체를 return : DATA + Http 상태 코드를 리턴 
		// 클라이언트에서 좀 더 세밀한 컨트롤을 처리할 때 사용됨
	// @ResponseBody : 리턴되는 값이 String, Data(DTO), List<dto> <== Data만 전송
	public ResponseEntity ex09(@RequestBody AjaxDTO ajaxDTO) {
	
	System.out.println("AjaxController ex09 요청 성공");
	System.out.println("param :" + ajaxDTO);
	
	// BackEnd DB의 로직을 처리 후 DB의 레코드 하나를 List<DTO> 객체에 저장 후 리턴
	List<AjaxDTO> dtoList = new ArrayList();
	dtoList.add(ajaxDTO); 				// index 0
	dtoList.add(new AjaxDTO("data1", "data2"));		// index1
	dtoList.add(new AjaxDTO("data11", "data22"));	// index2
	return new ResponseEntity<>(ajaxDTO, HttpStatus.OK);	
//	return new ResponseEntity<>(ajaxDTO, HttpStatus.NOT_FOUND);	
	}
	
	@PostMapping("/ex10")	// ajax에서 param1, param2를 넘겨준다. 
	// @RequestBody 로 클라이언트가 넘긴 파라미터 JSON형식이다라고 
	// 리턴을 ResposeEntity 객체를 return : DATA + Http 상태 코드를 리턴 
		// 클라이언트에서 좀 더 세밀한 컨트롤을 처리할 때 사용됨
	// @ResponseBody : 리턴되는 값이 String, Data(DTO), List<dto> <== Data만 전송
	public ResponseEntity ex10(@RequestBody AjaxDTO ajaxDTO) {
	
	System.out.println("AjaxController ex10 요청 성공");
	System.out.println("param :" + ajaxDTO);
	
	
	// BackEnd DB의 로직을 처리 후 DB의 레코드 하나를 List<DTO> 객체에 저장 후 리턴
	List<AjaxDTO> dtoList = new ArrayList();
	dtoList.add(ajaxDTO); 				// index 0
	dtoList.add(new AjaxDTO("data1", "data2"));		// index1
	dtoList.add(new AjaxDTO("data11", "data22"));	// index2
	
	return new ResponseEntity<>(dtoList, HttpStatus.OK);	
	}
	
	@PostMapping("/ajax-lab")	
	public @ResponseBody int plus(@RequestBody AjaxLabDTO ajaxLabDTO) {
		
		System.out.println("result :" +  ajaxLabDTO);
		
		int a1 = ajaxLabDTO.getAa();
		
		int b1 = ajaxLabDTO.getBb();
		
		int result = a1 + b1;
		
		System.out.println("result :" +  result);
		
		return result;	
	}
	
	
	
	@PostMapping("/movie/put") 
	public @ResponseBody String lab2(@RequestBody MovieDTO movieDTO) {
		System.out.println("AjaxController ex07 요청 성공");
		System.out.println("ajaxDTO : " + movieDTO);

//BackEnd DB의 로직을 처리후 DB의 레코드 하나를 DTO 객체에 저장후 리턴 

		
		String str = movieService.movieInsert(movieDTO); 
		
		return str;
	}

}
