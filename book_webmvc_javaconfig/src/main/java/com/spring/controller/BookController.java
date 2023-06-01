package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.BookDTO;
import com.spring.domain.SearchDTO;
import com.spring.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/book")
@Slf4j
public class BookController {
	@Autowired
	public BookService service;

	// insert.jsp �����ֱ� = > http://localhost:8080/book/insert+GET
	@GetMapping("/insert")
	public void insertForm() {
		log.info("���� ���� �߰� �� ��û");

	}

	@PostMapping("/insert")
	public String insertPost(BookDTO dto) {// �Է°� ��������
		log.info("���� ���� �߰� �� ��û ");
		// service ��������

		try {
			boolean insertFlag = service.insert(dto);
			if (insertFlag) {
				// �Է� ������
				return "redirect:/book/list";
			} else {
//			�Է� ���н�
				return "/product/insert";
			}

		} catch (Exception e) {
			System.out.println("����");
			return "/product/insert";
		}
	}
	// http://localhost:8080/book/list+GET list.jsp �����ֱ�

	@GetMapping("/list")
	public void listForm(Model model) {
		log.info("���� ��� �� ��û ");
		// ����ڰ� �ۼ��� �� ��������
		// service �۾�
		List<BookDTO> list = service.getList();
		model.addAttribute("list", list);

	}

	@GetMapping({ "/read", "/modify" })
	public void readGet(int code, Model model) {
		BookDTO dto = service.get(code);
		model.addAttribute("dto", dto);

	}

	@PostMapping("/modify")
	public String modifyForm(BookDTO dto, RedirectAttributes rttr) {
		try {
			boolean updateFlag = service.update(dto);
			if (updateFlag) {

				rttr.addAttribute("code", dto.getCode());
				return "redirect:/book/read";
			} else {
				return "/book/modify";

			}
		} catch (Exception e) {
			System.out.println("����");

		}
		return "/book/modify";
	}

	@GetMapping("/delete")
	public String deleteGet(int code) {
		log.info("�������� ���� " + code);
		 service.delete(code);
		 return "redirect:/book/list";
	}
	@GetMapping("/search")
	public String searchGet(SearchDTO search, Model model) {
		log.info("���� ���� �˻� "+search);
		List<BookDTO> list = service.getSearchList(search.getCriteria(),search.getKeyword());
		
		model.addAttribute("list",list);
		model.addAttribute("searchDTO",search);
		return "/book/list";
	}
}
