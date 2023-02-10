package com.mysite.sbb2.users;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mysite.sbb2.DataNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UsersService {
	
	//JPA 사용하기 위해 선언
	private final UsersRepository usersRepository;
	
	// users 테이블의 List 정보를 가지고 오는 메소드
	public List<Users> getList(){
		return this.usersRepository.findAll();
	}
		
		//상세 페이지 처리 메소드
		public Users getUsers(Integer idx) {
		
			Optional<Users> op = this.usersRepository.findById(idx);
			if(op.isPresent()) {
				return op.get();
			} else {
				throw new DataNotFoundException("요청한 파일을 찾지 못했습니다.");
			}
		
	}
}
