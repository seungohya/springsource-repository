package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.BoardDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {
//	@RequestMapping(value = "/read", method = RequestMethod.GET)
	@GetMapping("/read")
	public void readGet() {
		log.info("read��û");
	}

//	@RequestMapping(value = "/register", method = RequestMethod.GET)
	@GetMapping("/register")
	public void registerGet() {
		log.info("register��û");
	}

//	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	@GetMapping("/modify")
	public void modifyGet() {
		log.info("modify��û");
	}

//	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	@GetMapping("/remove")
	public void removeGet() {
		log.info("remove��û");
	}

	// Model = request.setAttribute()
	// addAttribute () - ��ȸ������ �����͸� ���� (��ü ���·� �� ���� �Ұ� - �ּ��ٿ� ���󰡴¹��)
	// addFlashAttribute () - �Ͽܼ����� �����͸� ���� (session�� ����� - ��ü���·� ���� ����)
	// HttpSession
//	@PostMapping("/register")
//	public String registerPost(BoardDTO dto, RedirectAttributes rttr) {
//		log.info("�۵�� ��û"+dto);
////		rttr.addAttribute("name", dto.getName());
////		rttr.addAttribute("password", dto.getPassword());
////		rttr.addAttribute("title", dto.getTitle());
////		rttr.addAttribute("content", dto.getContent());
//		rttr.addFlashAttribute("boardDTO", dto);
//		return "redirect:/board/read";
//	}
	//@ModelAttribute("dto") : ��ȣ �κ��� ���� ����
	//							Model ��ü ��� ���
	//							������ ��ü�� ���� �� �̸� ���� ���� 
	@PostMapping("/register")
	public void registerPost(@ModelAttribute("dto")BoardDTO dto, RedirectAttributes rttr) {
		log.info("�۵�� ��û" + dto);

	//BoardDTO ���� ������ �Ƿ��� forward �� �������� �� 

	}
}
