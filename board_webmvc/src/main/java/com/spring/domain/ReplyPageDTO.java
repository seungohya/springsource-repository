package com.spring.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ReplyPageDTO {

	private int replyCnt; // Ư�� �Խù��� �޸� ��� �� ��
	private List<ReplyDTO> list; // Ư�� �Խù� ��� ����Ʈ

}
