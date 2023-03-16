package com.ajax.dto;

import org.modelmapper.ModelMapper;

import com.ajax.entity.Movie;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class MovieDTO {

	private String backdrop_path; 
	private Long id_num ; 
	private String original_language; 
	private String original_title;
	private String overview ; 
	private String poster_path; 
	private String release_date; 
	private String title; 
	private Long vote_count; 
	
    private static ModelMapper modelMapper = new ModelMapper();

    //Client form 에서 넘어오는 값을 DTO에 담아서 Movie Entity 클래스에 적용후 DB에 저장  
    public Movie createMovie(){
        return modelMapper.map(this, Movie.class);
    }
    
    //DB에서 가져온 Movie Entity 클래스를 DTO 에 주입해서 client 로 전송 하기 위한 매핑 
    public static MovieDTO of(Movie movie) {
        return modelMapper.map(movie,MovieDTO.class);
    }
	
}
