package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.domain.Criteria;
import com.spring.domain.ReplyDTO;
import com.spring.domain.ReplyPageDTO;
import com.spring.mapper.BoardMapper;
import com.spring.mapper.ReplyMapper;

@Service
public class ReplyServiceImpl implements ReplyService {
	@Autowired
	private ReplyMapper reMapper;
	@Autowired
	private BoardMapper mapper;
	@Override
	public ReplyDTO reRead(int rno) {
		// TODO Auto-generated method stub
		return reMapper.reRead(rno);
	}

	@Transactional
	@Override
	public boolean reInsert(ReplyDTO dto) {
		// TODO Auto-generated method stub
		//´ñ±Û ¼ö Ãß°¡
		mapper.updateReplyCnt(dto.getBno(),1);
		//´ñ±Û µî·Ï
		return reMapper.reInsert(dto) == 1 ? true : false;
	}


	@Override
	public ReplyPageDTO reList(Criteria cri,int bno) {
		List<ReplyDTO> list =reMapper.reList(cri,bno);
		 int replyCnt= reMapper.getCountByBno(bno);
		 return new ReplyPageDTO(replyCnt, list);
	}


	@Override
	public boolean reUpdate(ReplyDTO dto) {
		// TODO Auto-generated method stub
		return reMapper.reUpdate(dto)==1 ? true : false;
	}


	@Override
	public boolean reDelete(int rno) {
		// TODO Auto-generated method stub
		ReplyDTO dto = reMapper.reRead(rno);
		//´ñ±Û¼ö Â÷°¨
		mapper.updateReplyCnt(dto.getBno(), -1);
		//´ñ±Û Á¦°Å
		return reMapper.reDelete(rno) == 1? true : false;
	}

}
