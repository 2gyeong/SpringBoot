package com.washour.www.member;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {

	private final MemberRepository memberRepository;
	
	public Member signUp(String id, String email, String password) {
		Member m = new Member();
		m.setId(id);
		m.setEmail(email);
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		m.setPassword(passwordEncoder.encode(password));
		
		this.memberRepository.save(m);
		return m;
	}
}
