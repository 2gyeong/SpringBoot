package com.mysite.sbb2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UsersRepository extends JpaRepository<Users, Integer> {

	
	// 2. regdate 컬럼을 기준으로 내림차순(Desc) 정렬
	 List<Users> findAllByOrderByRegDateDesc();
	
}
