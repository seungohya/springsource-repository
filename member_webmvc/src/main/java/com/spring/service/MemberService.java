package com.spring.service;

import com.spring.domain.AuthDTO;
import com.spring.domain.ChangeDTO;
import com.spring.domain.LoginDTO;
import com.spring.domain.MemberDTO;

public interface MemberService {
	//로그인
	public AuthDTO login(LoginDTO loginDTO);
	// 회원가입
	public boolean register(MemberDTO dto);
	//중복 아이디 체크
	public boolean dubId(String userid);
	//회원탈퇴
	public boolean leave(LoginDTO loginDTO);
	//비번수정
	public boolean changePwd(ChangeDTO changeDTO);
	

}
