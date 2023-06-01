package com.spring.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//페이지 나누기 정보 객체
//요청된 페이지 : pageNum
// 한 페이지당 목록 수 : amount
// 시작 페이지, 끝나는 페이지  =>  1     5    10/  11     15     20  이렇게 선택한 요청 페이지 앞뒤로 일정간격으로 바뀌어야한다.
//끝나는 페이지 재계산 : realEnd
//전체게시물 개수 : total
@Getter@Setter@ToString
public class PageDTO {
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	private int total;
	
	private Criteria criteria;
	
	public PageDTO (Criteria criteria, int total) {
		this.total =total;
		this.criteria =criteria;
		
		this.endPage = (int)(Math.ceil(criteria.getPage()/10.0))*10;
		this.startPage = this.endPage - 9;
		int realEnd = (int)(Math.ceil(total/1.0)/criteria.getAmount());
		if(realEnd < this.endPage) {
			this.endPage = realEnd;
			
		}
		this.prev = this.startPage > 1;
		this.next = this.endPage <realEnd;
		
	}
}
