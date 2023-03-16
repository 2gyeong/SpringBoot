package com.ajax.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

	 @Id
	    @Column(name="movie_id")
	    @GeneratedValue(strategy = GenerationType.AUTO)
		private Long id ; 
	    
	    @Column(nullable = false, length = 500)
		private String backdrop_path; 
	    
	    @Column(nullable = false)
		private Long id_num ; 
		
	    @Column(nullable = false, length = 500)
		private String original_language; 
		
	    @Column(nullable = false, length = 500)
		private String original_title;
		
	    @Column(nullable = false, length = 500)
		private String overview ; 
		
	    @Column(nullable = false, length = 500)
		private String poster_path; 
		
	    @Column(nullable = false, length = 500)
		private String release_date; 
		
	    @Column(nullable = false, length = 500)
		private String title; 
		
	    @Column(nullable = false)
		private Long vote_count; 
}
