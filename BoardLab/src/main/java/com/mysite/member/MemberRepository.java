package com.mysite.member;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysite.member.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {
	
	// Select * from Member where email = ?
	Optional<Member> findByEmail(String email);
	
}