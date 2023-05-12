package com.spring.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.domain.MemberDTO;

public interface MemberService {
	public boolean insertMember(MemberDTO dto);
	public boolean updateMember(MemberDTO dto);
	public boolean deleteMember(@Param("userid") String userid, @Param("password") String password);
	public MemberDTO getRow (@Param("userid") String userid ,@Param("password") String password);
	public List<MemberDTO> getRows();
	

}
