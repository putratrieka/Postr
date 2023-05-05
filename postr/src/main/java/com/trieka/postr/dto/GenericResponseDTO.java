package com.trieka.postr.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericResponseDTO<T> {
	
	public static String SUCCESS = "SUCCESS";
	public static String FAILED = "FAILED";

	private String status;
	
	private String message;
	
	private T Content;
	
	
	
}
