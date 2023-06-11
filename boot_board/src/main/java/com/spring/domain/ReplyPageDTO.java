package com.spring.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ReplyPageDTO {

	private int replyCnt; // 특정 게시물에 달린 댓글 총 수
	private List<ReplyDTO> list; // 특정 게시물 댓글 리스트

}
