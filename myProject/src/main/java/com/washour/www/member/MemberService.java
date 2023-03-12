package com.washour.www.member;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {

	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;
	
	public Member signUp(String username, String email, String password, String address) {
		Member m = new Member();
		m.setUsername(username);
		m.setEmail(email);
		m.setPassword(passwordEncoder.encode(password));
		m.setAddress(address);
		
		this.memberRepository.save(m);
		return m;
	}
}
