package com.spring.console;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.BoardDTO;
import com.spring.service.BoardService;

public class BoardMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
        BoardService service = (BoardService) ctx.getBean("board");

        // 게시글 작성
//        BoardDTO dto = new BoardDTO();
//        dto.setTitle("스프링 이란?");
//        dto.setContent("스프링 게시판");
//        dto.setWriter("아무개");
//        boolean result = service.insertBoard(dto);
//        System.out.println(result ? "입력성공" : "입력실패");
        
     
//        dto.setBno(1);
//        boolean result = service.deleteBoard(1);
//        System.out.println(result ? "삭제성공" : "삭제실패");
        
        
        BoardDTO dto = new BoardDTO();
//        dto.setBno(2);
//        dto.setTitle("스프링");
//        dto.setContent("스프링 제어의 역전 IoC ");
//        boolean result = service.updateBoard(dto);
//        System.out.println(result ? "수정성공" : "수정실패");
//        
//        List<BoardDTO> list1 = service.getRows();
//        for( BoardDTO boardDTO : list1) {
//        	System.out.println(boardDTO);
//        }
        
        dto = service.getRow(3);
        System.out.println(dto);
    }
}


