package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/security")
public class SecurityController {
	@GetMapping("/login")
	public void loginGet() {
		log.info("로그인 폼 요청");
	}
	@GetMapping("/userpage")
	public void userpage() {
		log.info("유저페이지 폼 요청");
	}
	@GetMapping("/adminpage")
	public void adminpage() {
		log.info("관리자 페이지 폼 요청");
	}
	

	@GetMapping("/login-error")
	public String loginError(org.springframework.ui.Model model) {
	   model.addAttribute("error", "아이디나 비밀번호를 확인해 주세요");
	    return "/security/login";
	}



}
