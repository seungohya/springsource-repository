package com.spring.domain;


public class BookDTO {
	 
	private int code;
	private String title;
	private String writer;
	private int price;
	private String description;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "BookDTO [code=" + code + ", title=" + title + ", writer=" + writer + ", price=" + price
				+ ", description=" + description + "]";
	}
	public BookDTO() {
		super();
		this.code = code;
		this.title = title;
		this.writer = writer;
		this.price = price;
		this.description = description;
	}
	public BookDTO(int code, String title, String writer, int price, String description) {
	    super();
	    this.code = code;
	    this.title = title;
	    this.writer = writer;
	    this.price = price;
	    this.description = description;
	}

}
