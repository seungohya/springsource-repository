package com.spring.memo.entity;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity // 테이블 어노테이션
public class Member {
	@Id
	@Column(name = "member_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false, length = 50)
	private String name;
	@Column(unique = true)
	private String email;
	@Column(nullable = false, length = 50)
	private String password;
	@Column(nullable = false, length = 100)
	private String address;

}
