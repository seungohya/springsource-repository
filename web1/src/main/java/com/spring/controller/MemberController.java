package com.spring.controller;

import java.lang.reflect.Member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.domain.LoginDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("member")
public class MemberController {
	// GET + POST 둘 다 응답
//		@RequestMapping("/login")//http://localhost:8080/member/login
	
	//사용자 입력 값 가져오기
	//1.HttpServletRequest 사용하기
	//2.변수사용 : 변수명은 폼 태그 name 과 일치 2) 폼 태그 name 과 일치하지 않을 때 @RequestParam 사용
	//3.
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@GetMapping("/login")
	public void loginGet(HttpServletRequest req) {
		log.info("login...");
		log.info("method" + req.getMethod());
//			return "/member/login";
	}
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	@GetMapping("/login")
//	public void loginPost(HttpServletRequest req) {
//		log.info("login post...");
//		log.info("method" + req.getMethod());
//		System.out.println(req.getParameter("id"));
//		System.out.println(req.getParameter("password"));
//
//	}

//	@PostMapping("/login")
//	public void loginPost(@RequestParam("userid")String id , String password) {
//		log.info("login post...");
//		
//		System.out.println("id "+id);
//		System.out.println("password "+password);
//	}
	@PostMapping("/login")
	public String loginPost(LoginDTO dto ) {
		log.info("login post...");
		
//		model.addAttribute("id",dto.getId());
		
		System.out.println("id "+dto.getId());
		System.out.println("password "+dto.getPassword());
		return "/member/main";
	}
//	@RequestMapping("/register") // http://localhost:8080/member/register
	@GetMapping("/register") 
	public void registerGet() {
		log.info("register...");
//			return "/member/register";
	}
	@PostMapping("/register")
	public String registerPost(LoginDTO dto ) {
		log.info("회원가입 요청");
		log.info(dto.toString());
		//redirect : 를 해주면 DispatchatServlet 이 동작해서 경로요청이 된다
		// == response.sendRedirect () 와 같음
		return "redirect:/member/login";
		
	}
}
