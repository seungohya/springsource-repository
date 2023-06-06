package com.spring.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;

/*
 * java.util.Collection interface
 * -java.util.List interface
 *  ��java.util.ArrayList
 *  ��java.util.LinkedList
 *  
 * -java.util.Set interface
 *  ��java.util.HashSet
 *  
 *  ? extends GrantedAuthority:  GrantedAuthority �� �ڼյ鸸 ���� 
 *  
 *  ==> List<GrantedAuthority> , Set<GrantedAuthority>
 *  
 *  ==> dto.getAuthority() => List<SpUserAuthority> ==> SpUserAuthorityDTO �� GrantedAuthority ���� ��ü ����
 */
@Getter
public class CustomUser extends User {
	
	private SpUserDTO dto;
	
	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		
	}

	public CustomUser(SpUserDTO dto) {
		super(dto.getUserid(), dto.getPassword(),dto.getAuthorities().stream().map(auth-> new SimpleGrantedAuthority(auth.getAuthority())).collect(Collectors.toList()));
		this.dto = dto;
	}

}
