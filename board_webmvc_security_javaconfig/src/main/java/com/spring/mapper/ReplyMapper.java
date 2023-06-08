package com.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.domain.Criteria;
import com.spring.domain.ReplyDTO;

public interface ReplyMapper {
	public ReplyDTO reRead(int rno);
	public int reInsert(ReplyDTO dto);
	public List<ReplyDTO> reList(@Param("cri") Criteria cri ,@Param("bno")int bno);
	public int getCountByBno (int bno);
	public int reUpdate(ReplyDTO dto);
	public int reDelete(int rno);
	public int deleteAll (int bno);
}
