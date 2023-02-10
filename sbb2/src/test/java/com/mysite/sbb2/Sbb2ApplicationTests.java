package com.mysite.sbb2;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.sbb2.users.Users;
import com.mysite.sbb2.users.UsersRepository;

@SpringBootTest
class Sbb2ApplicationTests {
	
	@Autowired		// 객체 자동 주입 (DI)
	private UsersRepository usersRepository;

	/* 
	// 1. insert 값 5개
	@Test
	void insertUsers() {
		
		Users u1 = new Users();
		u1.setCnt(0);
		u1.setEmail("aaa@aaa.com");
		u1.setName("신짱구");
		u1.setPass("1234");	
		u1.setRegdate(LocalDateTime.now());
		this.usersRepository.save(u1);
		
		
		Users u2 = new Users();
		u2.setCnt(0);
		u2.setEmail("bbb@aaa.com");
		u2.setName("신짱아");
		u2.setPass("1234");
		u2.setRegdate(LocalDateTime.now());
		this.usersRepository.save(u2);
		
		Users u3 = new Users();
		u3.setCnt(0);
		u3.setEmail("ccc@aaa.com");
		u3.setName("봉미선");
		u3.setPass("1234");
		u3.setRegdate(LocalDateTime.now());
		this.usersRepository.save(u3);
		
		Users u4 = new Users();
		u4.setCnt(0);
		u4.setEmail("ddd@aaa.com");
		u4.setName("신형만");
		u4.setPass("1234");
		u4.setRegdate(LocalDateTime.now());
		this.usersRepository.save(u4);
		
		Users u5 = new Users();
		u5.setCnt(0);
		u5.setEmail("eee@aaa.com");
		u5.setName("흰둥이");
		u5.setPass("1234");
		u5.setRegdate(LocalDateTime.now());
		this.usersRepository.save(u5);
		
		
	}
	
	*/
	
	/**/
	// 2. regdate 컬럼을 기준으로 내림차순(Desc) 정렬
	
	@Test	
	public void List() {
		List<Users> all =
				this.usersRepository.findAllByOrderByRegDateDesc();
		
		System.out.println("총 개수 :" + all.size());
		
		for(Users u : all) {
			
			System.out.println(u.getIdx());
			System.out.println(u.getName());
			System.out.println(u.getPass());
			System.out.println(u.getEmail());
			System.out.println(u.getRegDate());
			System.out.println(u.getCnt());
			System.out.println("====================");
		}
		
	
		}
		
		
	/*		

	// 3. idx 3번의 name과 email 주소를 수정
	@Test
	public void test2() {
		Optional<Users> update = this.usersRepository.findById(3);
		
		Users u6 = update.get();
		u6.setName("김철수");
		u6.setEmail("kkk@kkk.com");
		
		this.usersRepository.save(u6);
	}
	
	// idx 4번의 값을 삭제
	@Test
	public void test3() {
		Optional<Users> dt = this.usersRepository.findById(4);
		Users u7 = dt.get();
		this.usersRepository.delete(u7);
		
	}
*/
}
