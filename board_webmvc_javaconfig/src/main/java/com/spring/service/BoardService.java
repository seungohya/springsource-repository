package com.spring.service;

import java.util.List;

import com.spring.domain.AttachFileDTO;
import com.spring.domain.BoardDTO;
import com.spring.domain.Criteria;

public interface BoardService {
	// 전체리스트 가져오기
	public List<BoardDTO> getList(Criteria criteria);
	//글등록
	public boolean register(BoardDTO boardDTO);

	// 상세번호 가져오기
	public BoardDTO read(int bno);

	// 정보 수정
	public boolean modify(BoardDTO boardDTO);
	
	//글 삭제
	public boolean remove (int bno);
	//전체게시물 개수
	public int getTotalCnt(Criteria criteria);
	
	//첨부파일 가져오기
	public List<AttachFileDTO> getAttachList(int bno);
	
	public List<AttachFileDTO> oldFiles();

}
