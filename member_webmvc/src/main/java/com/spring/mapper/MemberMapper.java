package com.spring.mapper;

import org.springframework.stereotype.Repository;

import com.spring.domain.AuthDTO;
import com.spring.domain.ChangeDTO;
import com.spring.domain.LoginDTO;
import com.spring.domain.MemberDTO;
@Repository
public interface MemberMapper {
	public AuthDTO login (String userid);
	public int register(MemberDTO dto);
	public String getPass(String userid);
	public int dupId(String userid);
	public int leave(String userid);
	public int updatePass (ChangeDTO changeDTO);
}
