package com.spring.memo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor@NoArgsConstructor
@Data //get, set, equals, toString, hashCode..
public class ItemDTO {
	private int no;
	private String name;
	private int price;
	
}
