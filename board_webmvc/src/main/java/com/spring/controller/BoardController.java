package com.spring.controller;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.BoardDTO;
import com.spring.domain.Criteria;
import com.spring.domain.PageDTO;
import com.spring.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/board")
public class BoardController {
	@Autowired
	public BoardService service;
	
	@GetMapping("/list")
	public void getRows(Criteria criteria,Model model) {
		log.info("전체 리스트 출력 요청 ");
		log.info("type"+Arrays.toString(criteria.getTypeArr()));
		//사용자가 요청한 번호에 맞는 게시물 목록
	    List<BoardDTO> list =  service.getList(criteria);
	    //전체 게시물 개수
	    int total = service.getTotalCnt(criteria);
		model.addAttribute("list",list);
		model.addAttribute("pageDTO",new PageDTO(criteria, total));
	}
	
	@GetMapping("/register")
	public void registerGet() {
		log.info("register 폼 요청");
	}
	@PostMapping("/register")
	public String registerPost(BoardDTO boardDTO, RedirectAttributes rttr, Criteria cri) {
	    log.info("register 등록 요청" + boardDTO);
	    if (service.register(boardDTO)) {
	        log.info("글 번호: " + boardDTO.getBno());
	        rttr.addFlashAttribute("result", boardDTO.getBno());
	    	rttr.addAttribute("page",cri.getPage());
			rttr.addAttribute("amount",cri.getAmount());
	        return "redirect:/board/list";
	    }
	    return "/board/register";
	}

	@GetMapping({"/read","/modify"})
	public void readGet(int bno, Model model,@ModelAttribute("cri") Criteria criteria) {
		log.info("상세정보 요청"+bno);
		BoardDTO dto = service.read(bno);
		model.addAttribute("read",dto);
		
	}
	@PostMapping("/modify")
	public String modifyPost(BoardDTO boardDTO, RedirectAttributes rttr, Criteria cri) {
		log.info("수정 폼 전송"+cri);
		if (service.modify(boardDTO)) {
			rttr.addFlashAttribute("result","success");
			rttr.addAttribute("page",cri.getPage());
			rttr.addAttribute("amount",cri.getAmount());
			return "redirect:/board/list";
		}
		else {
			return "/board/modify";
		}
		
	}@GetMapping("/remove")
	public String removeGet(int bno, RedirectAttributes rttr ,@ModelAttribute("cri") Criteria cri) {
		log.info("삭제 요청" + bno);
		if (service.remove(bno)) {
			rttr.addFlashAttribute("result","success");
			rttr.addAttribute("page",cri.getPage());
			rttr.addAttribute("amount",cri.getAmount());
			return "redirect:/board/list";
		}
		return "false";
	}
}
