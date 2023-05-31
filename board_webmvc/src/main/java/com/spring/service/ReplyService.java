package com.spring.service;

import java.util.List;

import com.spring.domain.Criteria;
import com.spring.domain.ReplyDTO;
import com.spring.domain.ReplyPageDTO;

public interface ReplyService {
	public ReplyDTO reRead(int rno);
	public boolean reInsert(ReplyDTO dto);
	//댓글 목록만 처리
	//public List<ReplyDTO>getList*Criterial cri, int bno);
	
	//댓글 총 수 , 목록 처리 포함
	public ReplyPageDTO reList(Criteria cri, int bno);
	public boolean reUpdate(ReplyDTO dto);
	public boolean reDelete(int rno);
}
