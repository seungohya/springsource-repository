package com.spring.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//������ ������ ���� ��ü
//��û�� ������ : pageNum
// �� �������� ��� �� : amount
// ���� ������, ������ ������  =>  1     5    10/  11     15     20  �̷��� ������ ��û ������ �յڷ� ������������ �ٲ����Ѵ�.
//������ ������ ���� : realEnd
//��ü�Խù� ���� : total
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
