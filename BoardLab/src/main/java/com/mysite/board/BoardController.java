package com.mysite.board;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BoardController {
	private final BoardService boardService;
	
	@GetMapping("/board")
	@ResponseBody
	public String index() {
		return "하이";
	}
	
	@GetMapping("/")
	 public String root() {
	 return "redirect:/board/list";
	 }
	
	@GetMapping("/board/list")
	public String list(Model model) {
	
		List<Board> boardList = this.boardService.getList();
		
		model.addAttribute("boardList", boardList);
		
		return "board_list";
	}
}
