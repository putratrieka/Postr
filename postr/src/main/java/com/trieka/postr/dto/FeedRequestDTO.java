package com.trieka.postr.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties
@Data
public class FeedRequestDTO {

	@NotBlank
	private String username;
	
	@NotBlank
	@Length(max = 100, min = 1)
	private String content;
	
}
