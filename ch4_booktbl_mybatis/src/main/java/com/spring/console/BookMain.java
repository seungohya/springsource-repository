package com.spring.console;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.BookDTO;

import com.spring.service.BookService;
import com.spring.service.BookServiceImpl;

public class BookMain {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");

		// servic 호출
		BookService service = (BookService) ctx.getBean("service");
		// 도서 추가
		BookDTO insertDto = new BookDTO(1112,"자바기초2","이승찬2",14000,null);
		if(service.insertBook(insertDto)) {
			System.out.println("입력성공");
		}
		// 전체 도서 목록 가져오기

//	    BookService service = new BookServiceImpl(bookDAO);
//		List<BookDTO> list = service.getBookList();
//		for (BookDTO bookDTO : list) {
//			System.out.println(bookDTO);
			
		}
		//도서 수정
//		BookDTO updateDto = new BookDTO();
//		updateDto.setCode(1111);
//		updateDto.setPrice(20000);
//		if(service.updateBook(updateDto)) {
//			System.out.println("수정성공");
//		}
//		//특정도서 조회
//		BookDTO row = service.getBook(1111);
//		System.out.println(row);
////도서 삭제
//	 	if(service.deleteBook(1001)) {
//	 		System.out.println("삭제 성공");
//	 	}
	}
