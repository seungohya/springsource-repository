package com.spring.memo.repository;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.memo.entity.Item;
import com.spring.memo.entity.Member;
import com.spring.memo.entity.OrderItem;
import com.spring.memo.entity.OrderStatus;
import com.spring.memo.entity.Orders;

@SpringBootTest
public class OrderRepositoryTest {
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private ItemRepository itemRepository;
//	@Test
//	public void createOrders() {
//		Member member = memberRepository.findById(1L).orElseThrow();
//		
//		Orders orders = Orders.builder().member(member).orderDate(LocalDateTime.now()).orderStatus(OrderStatus.OREDER).build();
//		System.out.println(orderRepository.save(orders)); 
//	}
	
	@Test
	public void createOrderItem() {
		
		Item item = itemRepository.findById(3L).orElseThrow();
		Orders orders =orderRepository.findById(1L).orElseThrow();
		OrderItem orderItem = OrderItem.builder().item(item).orders(orders).orderPrice(20000).count(2).regTime(LocalDateTime.now()).updateTime(LocalDateTime.now()).build();
		System.out.println(orderItemRepository.save(orderItem));
	}
}
