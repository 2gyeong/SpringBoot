package com.mysite.sbb2.users;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mysite.sbb2.DataNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UsersService {
	
	//JPA 사용하기 위해 선언
	private final UsersRepository usersRepository;
	
	
	// 리스트 - 페이징
	public Page<Users> getList(int page) {
		List<Sort.Order> sorts = new ArrayList<>();
		sorts.add(Sort.Order.desc("regDate"));
		Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
		return this.usersRepository.findAll(pageable);
	}
	

	//상세 페이지 처리 메소드
	public Users getUsers(Integer idx) throws DataNotFoundException {
	
		Optional<Users> op = this.usersRepository.findById(idx);
		if(op.isPresent()) {
			return op.get();
		} else {
			throw new DataNotFoundException("요청한 파일을 찾지 못했습니다. "); 
		}
	}
	
	// 등록
	public void insertSave(String name, String pass, String email) {
		Users u = new Users();
		u.setName(name);
		u.setPass(pass);
		u.setEmail(email);
		u.setCnt(0);
		u.setRegDate(LocalDateTime.now());
		
		this.usersRepository.save(u);
	}
	
}
