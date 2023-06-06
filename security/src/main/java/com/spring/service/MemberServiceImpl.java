package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.domain.SpUserAuthorityDTO;
import com.spring.domain.SpUserDTO;
import com.spring.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberMapper mapper;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
	@Transactional
	public boolean register(SpUserDTO dto) {
//		��й�ȣ ��ȣȭ
	dto.setPassword(encoder.encode(dto.getPassword()));
	//  ȸ������
	boolean result = mapper.register(dto) ==1;
	//  ȸ������ 
	mapper.registerAuth(new SpUserAuthorityDTO(dto.getUserid(),"ROLE_USER"));
//	mapper.registerAuth(new SpUserAuthorityDTO(dto.getUserid(),"ROLE_ADMIN"));
		
		return result;
	}

	
}
