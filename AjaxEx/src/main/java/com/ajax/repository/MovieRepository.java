package com.ajax.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajax.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
