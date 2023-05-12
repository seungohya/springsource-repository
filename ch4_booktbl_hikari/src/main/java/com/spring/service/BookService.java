package com.spring.service;

import java.util.List;

import com.spring.domain.BookDTO;

public interface BookService {
	boolean insertBook (BookDTO insertDto);
	boolean updateBook(BookDTO updateDto);
	
	BookDTO getBook(int code);
	List<BookDTO> getBookList();
	boolean deleteBook(int code);
}
