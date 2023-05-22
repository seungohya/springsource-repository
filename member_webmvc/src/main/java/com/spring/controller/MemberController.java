package com.spring.controller;

import java.lang.reflect.Member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.AuthDTO;
import com.spring.domain.ChangeDTO;
import com.spring.domain.LoginDTO;
import com.spring.domain.MemberDTO;
import com.spring.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService service;

	@GetMapping("/login")
	public void loginForm() {
		log.info("로그인 화면 폼");
	}

	@PostMapping("/login")
	public String loginPost(LoginDTO loginDTO, HttpSession session) {
		log.info("로그인 폼 전송" + loginDTO);
		AuthDTO authDTO = service.login(loginDTO);
		if(authDTO != null) {
			session.setAttribute("authDTO", authDTO); // session 등록
			
			return "redirect:/"; // 인덱스이동
		}else {
			return "redirect:/member/login";
		}
	}

	@GetMapping("/logout")
	public String logoutGet(HttpSession session) {
		log.info("로그아웃 세션헤재 시도");
		session.removeAttribute("authDTO"); // 세션 해제 index 이동
		return "redirect:/";
	}

	@GetMapping("/step1")
	public void stepGet() {
		log.info("약관 페이지 보여주기");

	}

	@PostMapping("/step1")
	public String processAgreement(RedirectAttributes rttr, boolean agree) {
		log.info("약관동의 " + agree);
		if (agree) {
			return "/member/register"; // 다시 약관 동의 페이지로 이동
		}
		rttr.addFlashAttribute("check", false);

		// 약관 동의가 체크된 경우
		// 다음 처리 로직 수행
		return "redirect:/member/step1"; // 다음으로 넘어가는 페이지로 리다이렉트
	}
	@PostMapping("/register")
	public String registerPost(MemberDTO dto) {
		log.info("회원가입 요청"+dto);
	   if (service.register(dto)) {
		   return "redirect:/member/login";
	   }else {
		   return"/member/register";
	   }
	    
	}
	@PostMapping("/dupId")
	@ResponseBody //controller 작업이 완료될 떄 viewResolver 를 동작시키지않음
	public String dupIdCheck(String userid) {
		log.info("중복아이디 체크"+userid);
		boolean idCheck = service.dubId(userid);
		if(idCheck) {
			return "true";
		}else {
			return "false";
		}
	}
	@GetMapping("/leave")
	public void leaveGet() {
		log.info("회원탈퇴 요청 페이지");
	}
	@PostMapping("/leave")
	public String leavePost(LoginDTO loginDTO, HttpSession session) {
	    log.info("회원탈퇴: " + loginDTO);
	    if (loginDTO.getPassword() != null && service.leave(loginDTO)) {
	        session.invalidate();
	        return "redirect:/";
	    }
	    return "redirect:/member/leave";
	}

	@GetMapping("/changePwd")
	public void changePwdGet() {
		log.info("비밀번호 변경 페이지 요청 ");
		
	}
	@PostMapping("/changePwd")
	public String changePwdGet(ChangeDTO changeDTO,HttpSession session) {
		log.info("비밀번호 변경 요청 "+changeDTO);
		//현재비밀번호 일치 확인 
		//true : 비밀번호 변경 => session 제거 => 로그인페이지 보여주기
		//false: 회원탈퇴 페이지 보여주기
		//비밀번호는 암호화
		if(service.changePwd(changeDTO)) {
			session.invalidate();
			return "redirect:/member/login";
		}
		return "redirect:/member/changePwd";
	}

}
