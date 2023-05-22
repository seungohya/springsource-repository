package com.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.spring.domain.AuthDTO;

public class AuthCheckInterceptor implements HandlerInterceptor {
	//http://localhost:8080/member/changePwd => ���ͼ��Ͱ� ��û ����ä��
	//session ������ �ִ��� Ȯ��
	//true : ���� ��� ��Ʈ�ѷ� ��û �ѱ��
	//false : �α��� �������� �̵�
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		AuthDTO authDTO = (AuthDTO)session.getAttribute("authDTO");
		if(authDTO!=null) {
			return true;
		}
		response.sendRedirect(request.getContextPath()+"/member/login");
	
		return false;
	}
	//postHandle() :��Ʈ�ѷ� �۾������� �߰��۾�
}
