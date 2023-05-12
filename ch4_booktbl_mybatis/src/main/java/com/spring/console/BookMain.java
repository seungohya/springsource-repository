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

		// servic ȣ��
		BookService service = (BookService) ctx.getBean("service");
		// ���� �߰�
		BookDTO insertDto = new BookDTO(1112,"�ڹٱ���2","�̽���2",14000,null);
		if(service.insertBook(insertDto)) {
			System.out.println("�Է¼���");
		}
		// ��ü ���� ��� ��������

//	    BookService service = new BookServiceImpl(bookDAO);
//		List<BookDTO> list = service.getBookList();
//		for (BookDTO bookDTO : list) {
//			System.out.println(bookDTO);
			
		}
		//���� ����
//		BookDTO updateDto = new BookDTO();
//		updateDto.setCode(1111);
//		updateDto.setPrice(20000);
//		if(service.updateBook(updateDto)) {
//			System.out.println("��������");
//		}
//		//Ư������ ��ȸ
//		BookDTO row = service.getBook(1111);
//		System.out.println(row);
////���� ����
//	 	if(service.deleteBook(1001)) {
//	 		System.out.println("���� ����");
//	 	}
	}
