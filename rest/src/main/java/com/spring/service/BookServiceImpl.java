package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.BookDTO;
import com.spring.mapper.BookMapper;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookMapper mapper;

	@Override
	public boolean insert(BookDTO dto) {
		// TODO Auto-generated method stub
		return mapper.insert(dto) == 1 ? true : false;
	}

	@Override
	public boolean delete(int code) {
		
		return mapper.delete(code) == 1 ? true : false;
	}

	@Override
	public boolean update(BookDTO dto) {
		
		return mapper.update(dto) ==1 ? true : false;
	}

	@Override
	public BookDTO get(int code) {
		// TODO Auto-generated method stub
		return mapper.read(code);
	}

	@Override
	public List<BookDTO> getList() {
		// TODO Auto-generated method stub
		return mapper.getRows();
	}

	@Override
	public List<BookDTO> getSearchList(String criteria, String keyword) {
	
		return mapper.search(criteria, keyword);
	}

}
