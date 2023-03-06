package com.mysite.board;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {

	private final BoardRepository boardRepository;
	
	public List<Board> getList(){
		return this.boardRepository.findAll();
	}
}
