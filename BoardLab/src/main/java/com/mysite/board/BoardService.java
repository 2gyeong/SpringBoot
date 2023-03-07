package com.mysite.board;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mysite.board.Board;
import com.mysite.board.BoardRepository;
import com.mysite.member.Member;
import com.mysite.member.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	
	private final BoardRepository boardRepository;
	private final MemberRepository memberRepository;
	
	
	public List<Board> getboardList(){
		return this.boardRepository.findAll();
	}
	
	public void save(Board board , String email) {
		
		board.setCreateDate(LocalDateTime.now());
		
		Optional<Member> board_db = this.memberRepository.findByEmail(email);
		
		board.setAuthor(board_db.get());
		
		this.boardRepository.save(board);
		
	}
	
	
	
	
	
}
