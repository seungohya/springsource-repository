package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.domain.AddDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CalcController {
	@GetMapping("/add")
	public void addForm() {
		log.info("add ��û");
	}
	//����� �Է� �� ��������
		//1.HttpServletRequest ����ϱ�
		//2.������� : �������� �� �±� name �� ��ġ 2) �� �±� name �� ��ġ���� ���� �� @RequestParam ���
		//3.���ε� ��ü ��� 
//	@PostMapping("/add")
//	public void addPost (int num1 , int num2 ) {
//		log.info("add Post ��û");
//		log.info("num1"+num1);
//		log.info("num2"+num2);
//		log.info("result"+(num1+num2));
//	}
//	@PostMapping("/add")
//	public void addPost (AddDTO dto) {
//		log.info("add Post ��û");
//		log.info("num1"+dto.getNum1());
//		log.info("num2"+dto.getNum2());
//		log.info("result"+(dto.getNum2()+dto.getNum1()));
//	}
	@PostMapping("/add")
	public String addPost (AddDTO dto,@ModelAttribute("page") String page, Model model) {
		log.info("add Post ��û");
		log.info("num1"+dto.getNum1());
		log.info("num2"+dto.getNum2());
		log.info("page"+page);
		int result =dto.getNum2()+dto.getNum1();
		log.info("result"+result);
	    model.addAttribute("result", result); 
	    //model.addAttribute("page", page); 
	    //result ���� result.jsp ���� ����ϱ� ���ؼ�
	    //model ��ü�� ����ؼ� request.setAttribute() �� ���� ������ ����
		return "result";//view resolve �� ���鼭 /WEB-INF/views/result.jsp �ڵ����� ����
	}
}
