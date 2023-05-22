package com.spring.service;

import com.spring.domain.AuthDTO;
import com.spring.domain.ChangeDTO;
import com.spring.domain.LoginDTO;
import com.spring.domain.MemberDTO;

public interface MemberService {
	//�α���
	public AuthDTO login(LoginDTO loginDTO);
	// ȸ������
	public boolean register(MemberDTO dto);
	//�ߺ� ���̵� üũ
	public boolean dubId(String userid);
	//ȸ��Ż��
	public boolean leave(LoginDTO loginDTO);
	//�������
	public boolean changePwd(ChangeDTO changeDTO);
	

}
