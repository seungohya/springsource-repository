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
		log.info("�α��� ȭ�� ��");
	}

	@PostMapping("/login")
	public String loginPost(LoginDTO loginDTO, HttpSession session) {
		log.info("�α��� �� ����" + loginDTO);
		AuthDTO authDTO = service.login(loginDTO);
		if(authDTO != null) {
			session.setAttribute("authDTO", authDTO); // session ���
			
			return "redirect:/"; // �ε����̵�
		}else {
			return "redirect:/member/login";
		}
	}

	@GetMapping("/logout")
	public String logoutGet(HttpSession session) {
		log.info("�α׾ƿ� �������� �õ�");
		session.removeAttribute("authDTO"); // ���� ���� index �̵�
		return "redirect:/";
	}

	@GetMapping("/step1")
	public void stepGet() {
		log.info("��� ������ �����ֱ�");

	}

	@PostMapping("/step1")
	public String processAgreement(RedirectAttributes rttr, boolean agree) {
		log.info("������� " + agree);
		if (agree) {
			return "/member/register"; // �ٽ� ��� ���� �������� �̵�
		}
		rttr.addFlashAttribute("check", false);

		// ��� ���ǰ� üũ�� ���
		// ���� ó�� ���� ����
		return "redirect:/member/step1"; // �������� �Ѿ�� �������� �����̷�Ʈ
	}
	@PostMapping("/register")
	public String registerPost(MemberDTO dto) {
		log.info("ȸ������ ��û"+dto);
	   if (service.register(dto)) {
		   return "redirect:/member/login";
	   }else {
		   return"/member/register";
	   }
	    
	}
	@PostMapping("/dupId")
	@ResponseBody //controller �۾��� �Ϸ�� �� viewResolver �� ���۽�Ű������
	public String dupIdCheck(String userid) {
		log.info("�ߺ����̵� üũ"+userid);
		boolean idCheck = service.dubId(userid);
		if(idCheck) {
			return "true";
		}else {
			return "false";
		}
	}
	@GetMapping("/leave")
	public void leaveGet() {
		log.info("ȸ��Ż�� ��û ������");
	}
	@PostMapping("/leave")
	public String leavePost(LoginDTO loginDTO, HttpSession session) {
	    log.info("ȸ��Ż��: " + loginDTO);
	    if (loginDTO.getPassword() != null && service.leave(loginDTO)) {
	        session.invalidate();
	        return "redirect:/";
	    }
	    return "redirect:/member/leave";
	}

	@GetMapping("/changePwd")
	public void changePwdGet() {
		log.info("��й�ȣ ���� ������ ��û ");
		
	}
	@PostMapping("/changePwd")
	public String changePwdGet(ChangeDTO changeDTO,HttpSession session) {
		log.info("��й�ȣ ���� ��û "+changeDTO);
		//�����й�ȣ ��ġ Ȯ�� 
		//true : ��й�ȣ ���� => session ���� => �α��������� �����ֱ�
		//false: ȸ��Ż�� ������ �����ֱ�
		//��й�ȣ�� ��ȣȭ
		if(service.changePwd(changeDTO)) {
			session.invalidate();
			return "redirect:/member/login";
		}
		return "redirect:/member/changePwd";
	}

}
