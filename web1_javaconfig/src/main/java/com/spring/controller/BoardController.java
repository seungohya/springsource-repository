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
		log.info("read요청");
	}

//	@RequestMapping(value = "/register", method = RequestMethod.GET)
	@GetMapping("/register")
	public void registerGet() {
		log.info("register요청");
	}

//	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	@GetMapping("/modify")
	public void modifyGet() {
		log.info("modify요청");
	}

//	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	@GetMapping("/remove")
	public void removeGet() {
		log.info("remove요청");
	}

	// Model = request.setAttribute()
	// addAttribute () - 일회성으로 데이터를 전달 (객체 상태로 값 전달 불가 - 주소줄에 따라가는방식)
	// addFlashAttribute () - 일외성으로 데이터를 전달 (session을 사용함 - 객체상태로 전달 가능)
	// HttpSession
//	@PostMapping("/register")
//	public String registerPost(BoardDTO dto, RedirectAttributes rttr) {
//		log.info("글등록 요청"+dto);
////		rttr.addAttribute("name", dto.getName());
////		rttr.addAttribute("password", dto.getPassword());
////		rttr.addAttribute("title", dto.getTitle());
////		rttr.addAttribute("content", dto.getContent());
//		rttr.addFlashAttribute("boardDTO", dto);
//		return "redirect:/board/read";
//	}
	//@ModelAttribute("dto") : 괄호 부분은 생략 가능
	//							Model 객체 대신 사용
	//							도메인 객체에 담을 떄 이름 지정 가능 
	@PostMapping("/register")
	public void registerPost(@ModelAttribute("dto")BoardDTO dto, RedirectAttributes rttr) {
		log.info("글등록 요청" + dto);

	//BoardDTO 값이 유지가 되려면 forward 로 움직여야 함 

	}
}
