package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.domain.SpUserDTO;
import com.spring.mapper.MemberMapper;
import com.spring.service.MemberService;
import com.spring.service.MemberServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/security")
public class SecurityController {
	@Autowired
	private MemberService service;

	@GetMapping("/register")
	public void registerGet() {
		log.info("ȸ������ �� ��û");
	}

	@PostMapping("/register")
	public String registerPost(SpUserDTO dto) {
		log.info("ȸ������ ��û" + dto);
		String path = service.register(dto) ? "redirect:/" : "/security/register";
		return path;
	}

	@GetMapping("/login")
	public void loginGet() {
		log.info("�α��� �� ��û");
	}

	@PreAuthorize("hasAnyAuthority('ROLE_USER')") // security-context.xml �� intercept-url �� ���� ����
	@GetMapping("/userpage")
	public void userPage() {
		log.info("���� ������ ��û ");
	}

	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	@GetMapping("/adminpage")
	public void adminPage() {
		log.info("���� ������ ��û ");
	}

	@GetMapping("/login-error")
	public String loginError(org.springframework.ui.Model model) {
		model.addAttribute("error", "���̵� ��й�ȣ�� Ȯ���� �ּ���");
		return "/security/login";
	}

	@GetMapping("/access-denied")
	public String accessDenied() {
		return "/security/denied";
	}

	@GetMapping("/auth")
	@ResponseBody
	public Authentication auth() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

}
