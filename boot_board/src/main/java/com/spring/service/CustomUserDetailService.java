package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.domain.CustomUser;
import com.spring.domain.MemberDTO;
import com.spring.mapper.MemberMapper;
//@Service("detail")
public class CustomUserDetailService implements UserDetailsService {
	@Autowired
	private MemberMapper mapper;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	MemberDTO memberDTO = mapper.read(username);
	//memberDTO �� User Ŭ���� ��� �޾Ƽ� ���� Ŭ������ �̿��ؼ� �����ؾ���
	
		return new CustomUser(memberDTO);
	}

}
