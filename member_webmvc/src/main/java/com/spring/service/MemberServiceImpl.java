package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.domain.AuthDTO;
import com.spring.domain.ChangeDTO;
import com.spring.domain.LoginDTO;
import com.spring.domain.MemberDTO;
import com.spring.mapper.MemberMapper;
@Service

public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberMapper mapper;
	@Autowired
	private BCryptPasswordEncoder bPasswordEncoder;
	

	 @Override
	    public AuthDTO login(LoginDTO loginDTO) {
	        // userid�� ȸ�������� ��ȸ�մϴ�.
	      String encodePass= mapper.getPass(loginDTO.getUserid());
	      
	        // �Է¹��� ��й�ȣ�� ��ȣȭ�� ��, ȸ�������� ��ȣȭ�� ��й�ȣ�� ��Ī�մϴ�.
	        if (bPasswordEncoder.matches(loginDTO.getPassword(), encodePass)) {
	            // ��Ī�Ǹ� �α��� ������ ��ȯ�մϴ�.
	             return mapper.login(loginDTO.getUserid());
	        } else {
	            // ��Ī���� ������ �α��� ���и� ��ȯ�մϴ�.
	            return null;
	        }
	    }
	@Override
	public boolean register(MemberDTO dto) {
		//��й�ȣ ��ȣȭ : encode(��ȣȭ�� ���� �ڵ�)
		//				matches (��ȣȭ �ϱ� ��, ��ȣȭ �ڵ�)
		//				1234, ��ȣȭ�� �ڵ� 
		dto.setPassword(bPasswordEncoder.encode(dto.getPassword()));
		return mapper.register(dto) == 1?true:false;
	}
	@Override
	public boolean dubId(String userid) {
		// TODO Auto-generated method stub
		return mapper.dupId(userid) > 0 ? false:true;
	}
	@Override
	public boolean leave(LoginDTO loginDTO) {
	    if (loginDTO.getPassword() == null) {
	        // ��й�ȣ ���� null�� ��� ���� ó��
	        throw new IllegalArgumentException("��й�ȣ�� �Է����ּ���.");
	    }
	    
	    String encodePass = mapper.getPass(loginDTO.getUserid());
	    if (bPasswordEncoder.matches(loginDTO.getPassword(), encodePass)) {
	        return mapper.leave(loginDTO.getUserid()) == 1;
	    }
	    return false;
	}
	@Override
	public boolean changePwd(ChangeDTO changeDTO) {
		String encodePass = mapper.getPass(changeDTO.getUserid());
		if(bPasswordEncoder.matches(changeDTO.getCurrentPass(), encodePass)) {
			changeDTO.setNewPass(bPasswordEncoder.encode(changeDTO.getNewPass()));
		return mapper.updatePass(changeDTO) == 1 ? true : false;
	}return false;
	}
}
