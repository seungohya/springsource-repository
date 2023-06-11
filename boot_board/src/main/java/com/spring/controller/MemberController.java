package com.spring.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/member")
public class MemberController {
	@GetMapping("/login")
	public void loginGet() {
		log.info("�α��� �� ��û");
	}
	@GetMapping ("/login-error")
	public String loginError(Model model) {
	    model.addAttribute("error", "���̵� ��й�ȣ�� Ȯ���� �ּ���");
	    return "/member/login";
	}
	@GetMapping("/admin")
	public void adminGet() {
		log.info("admin ��û");
	}
	
	@GetMapping("/auth")
	@ResponseBody
	public Authentication auth() {
		return SecurityContextHolder.getContext().getAuthentication();
	}
}
