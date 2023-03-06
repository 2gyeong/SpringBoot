package com.mysite;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.board.Board;
import com.mysite.board.BoardRepository;

@SpringBootTest
class BoardLabApplicationTests {

	@Autowired
	private BoardRepository boardRepository;
	/*
	@Test
	void test1() {
		Board b1 = new Board();
		
		
		b1.setContent("내용");
		b1.setSubject("제목");
		b1.setCreateDate(LocalDateTime.now());
		this.boardRepository.save(b1);
	}
	*/

	@Test
	void test2() {
		List<Board> all = this.boardRepository.findAll();
		assertEquals(1, all.size());
		
		Board b = all.get(0);
		assertEquals("내용", b.getContent());
	}
}
