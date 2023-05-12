package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller//@Component �ڽ�
@RequestMapping("/sample")//option, basicController �� http://localhost:8080/sample/** ��û�� �����ϴ� ��Ʈ�ѷ� ��� �������ִ� ��
public class BasicController {
	//��Ʈ�ѷ� �ȿ� �Ϲ� �޼ҵ� �ۼ� ����
	//�Ϲ� �޼ҵ�� @RequestMapping ������̼��� ������ ������ �� 
	
//	@RequestMapping("/basic")
	@GetMapping("/basic")
	public void basic() {
		log.info("basic......��û");
		//��Ʈ�ѷ� ������ (���� ���� ����) ViewResolver �� ���� ��
		//������ �ִٸ� /WEB-INF/views/���ϰ�.jsp
		//������ ���ٸ� �ּ��� ���ڿ� ViewResolver ��  /WEB-INF/views/sample/basic.jsp ���� ���� ��� ����
		//�޽��� ���� [/WEB-INF/views/sample/basic.jsp]��(��) ã�� �� �����ϴ�.
	}
}
