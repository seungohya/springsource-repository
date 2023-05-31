package com.spring.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter@Setter@NoArgsConstructor@ToString@AllArgsConstructor
public class FileDTO {
	private String name;
	
	//file 요소 처리
	private MultipartFile[] file;
}
