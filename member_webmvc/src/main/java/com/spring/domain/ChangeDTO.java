package com.spring.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter
@NoArgsConstructor@AllArgsConstructor@ToString
public class ChangeDTO {
//change.jsp ¿Í ÀÏÄ¡
	private String userid;
	private String currentPass;
	private String newPass;
	
	
}
