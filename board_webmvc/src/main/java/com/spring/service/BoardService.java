package com.spring.service;

import java.util.List;

import com.spring.domain.BoardDTO;
import com.spring.domain.Criteria;

public interface BoardService {
	// ��ü����Ʈ ��������
	public List<BoardDTO> getList(Criteria criteria);

	public boolean register(BoardDTO boardDTO);

	// �󼼹�ȣ ��������
	public BoardDTO read(int bno);

	// ���� ����
	public boolean modify(BoardDTO boardDTO);
	
	//�� ����
	public boolean remove (int bno);
	//��ü�Խù� ����
	public int getTotalCnt(Criteria criteria);
}
