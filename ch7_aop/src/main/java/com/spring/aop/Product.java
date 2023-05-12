package com.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class Product {
	private String company;
	private String pname;
	private String price;
	
	public void getInfo() throws Exception {			
		System.out.println("ȸ��� : "+company);
		System.out.println("��ǰ�� : "+pname);
		System.out.println("���� : "+price);
		throw new Exception("���� ���� �߻�");
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}	
}