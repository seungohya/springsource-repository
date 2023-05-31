package com.spring.domain;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter@Setter@ToString@NoArgsConstructor@AllArgsConstructor
public class BoardDTO {
	private int bno;
	private String title;
	private String writer;
	private String content;
	private Date regdate;
	private Date updatedate;
	private int replyCnt;
	//첨부파일 정보
	private List<AttachFileDTO> attachList;
}
