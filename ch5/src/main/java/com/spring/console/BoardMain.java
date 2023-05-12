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

        // �Խñ� �ۼ�
//        BoardDTO dto = new BoardDTO();
//        dto.setTitle("������ �̶�?");
//        dto.setContent("������ �Խ���");
//        dto.setWriter("�ƹ���");
//        boolean result = service.insertBoard(dto);
//        System.out.println(result ? "�Է¼���" : "�Է½���");
        
     
//        dto.setBno(1);
//        boolean result = service.deleteBoard(1);
//        System.out.println(result ? "��������" : "��������");
        
        
        BoardDTO dto = new BoardDTO();
//        dto.setBno(2);
//        dto.setTitle("������");
//        dto.setContent("������ ������ ���� IoC ");
//        boolean result = service.updateBoard(dto);
//        System.out.println(result ? "��������" : "��������");
//        
//        List<BoardDTO> list1 = service.getRows();
//        for( BoardDTO boardDTO : list1) {
//        	System.out.println(boardDTO);
//        }
        
        dto = service.getRow(3);
        System.out.println(dto);
    }
}


