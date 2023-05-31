package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.domain.AttachFileDTO;
import com.spring.domain.BoardDTO;
import com.spring.domain.Criteria;
import com.spring.domain.ReplyDTO;
import com.spring.mapper.AttachMapper;
import com.spring.mapper.BoardMapper;
import com.spring.mapper.ReplyMapper;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service

public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardMapper mapper;
	@Autowired
	private AttachMapper attachMapper;
	@Autowired
	private ReplyMapper remapper;
	@Override
	public List<BoardDTO> getList(Criteria criteria) {

		return mapper.getList(criteria);
	}

	@Transactional
	@Override
	public boolean register(BoardDTO boardDTO) {
		// TODO Auto-generated method stub
		boolean insertFlag = mapper.register(boardDTO) == 1 ? true : false;
		if (boardDTO.getAttachList() == null || boardDTO.getAttachList().size() == 0) {
			return insertFlag;
		}
		boardDTO.getAttachList().forEach(attach -> {
			attach.setBno(boardDTO.getBno());
			attachMapper.insert(attach);
		});
		return insertFlag;
	}

	@Override
	public BoardDTO read(int bno) {
//		BoardDTO dto = mapper.readAttach(bno);
//		log.info("상세정보 + 첨부파일 요청"+dto);

		return mapper.read(bno);
	}
	@Transactional
	@Override
	public boolean modify(BoardDTO boardDTO) {
		boolean updateFlag = mapper.modify(boardDTO) == 1 ? true : false;
		// 기존 첨부목록 제거
		attachMapper.deleteAll(boardDTO.getBno());
//		첨부파일이 있다면
		if (boardDTO.getAttachList() == null || boardDTO.getAttachList().size() == 0) {
			
			return updateFlag;
		}
		// 첨부 목록 삽입
		boardDTO.getAttachList().forEach(attach -> {
			attach.setBno(boardDTO.getBno());
			attachMapper.insert(attach);

		});
		return updateFlag;
		// 기존첨부 목록 제거

	}
	@Transactional
	@Override
	public boolean remove(int bno) {
		
		//자식 댓글 삭제
		remapper.deleteAll(bno);
		//첨부파일 삭제
		attachMapper.deleteAll(bno);
		return mapper.remove(bno) == 1 ? true : false;
	}

	@Override
	public int getTotalCnt(Criteria criteria) {

		return mapper.totalCnt(criteria);
	}

	@Override
	public List<AttachFileDTO> getAttachList(int bno) {

		return attachMapper.select(bno);
	}

	@Override
	public List<AttachFileDTO> oldFiles() {
		// TODO Auto-generated method stub
		return attachMapper.oldFiles();
	}

}
