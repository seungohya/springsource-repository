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
	        // userid로 회원정보를 조회합니다.
	      String encodePass= mapper.getPass(loginDTO.getUserid());
	      
	        // 입력받은 비밀번호를 암호화한 후, 회원정보의 암호화된 비밀번호와 매칭합니다.
	        if (bPasswordEncoder.matches(loginDTO.getPassword(), encodePass)) {
	            // 매칭되면 로그인 성공을 반환합니다.
	             return mapper.login(loginDTO.getUserid());
	        } else {
	            // 매칭되지 않으면 로그인 실패를 반환합니다.
	            return null;
	        }
	    }
	@Override
	public boolean register(MemberDTO dto) {
		//비밀번호 암호화 : encode(암호화할 원본 코드)
		//				matches (암호화 하기 전, 암호화 코드)
		//				1234, 암호화된 코드 
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
	        // 비밀번호 값이 null인 경우 예외 처리
	        throw new IllegalArgumentException("비밀번호를 입력해주세요.");
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
