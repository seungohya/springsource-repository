package com.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.domain.BoardDTO;
import com.spring.domain.Criteria;

public interface BoardMapper {
	public List<BoardDTO> getList(Criteria criteria);
	public int register(BoardDTO boardDTO);
	public BoardDTO read (int bno);
	public int modify (BoardDTO boardDTO);
	public int remove(int bno);
	public int totalCnt(Criteria criteria);
	public int updateReplyCnt(@Param("bno")int bno, @Param ("amount") int amount);
	
	//상세 조회 + 파일정보
	public BoardDTO readAttach (int bno);
}
