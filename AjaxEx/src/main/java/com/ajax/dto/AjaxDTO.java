package com.ajax.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // 모든 필드의 값을 인풋 받는 생성자 주입
@NoArgsConstructor	// 기본 생성자 
public class AjaxDTO {

	private String param1;
	private String param2;
}
