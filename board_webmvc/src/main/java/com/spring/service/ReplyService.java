package com.spring.service;

import java.util.List;

import com.spring.domain.Criteria;
import com.spring.domain.ReplyDTO;
import com.spring.domain.ReplyPageDTO;

public interface ReplyService {
	public ReplyDTO reRead(int rno);
	public boolean reInsert(ReplyDTO dto);
	//��� ��ϸ� ó��
	//public List<ReplyDTO>getList*Criterial cri, int bno);
	
	//��� �� �� , ��� ó�� ����
	public ReplyPageDTO reList(Criteria cri, int bno);
	public boolean reUpdate(ReplyDTO dto);
	public boolean reDelete(int rno);
}
