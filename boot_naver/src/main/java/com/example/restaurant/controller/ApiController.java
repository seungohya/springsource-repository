package com.example.restaurant.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restaurant.naver.service.WishListService;
import com.example.restaurant.wishlist.dto.WishListDTO;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/restaurant")
public class ApiController {
	@Autowired
	private WishListService wishListService;

	@GetMapping("/search")
	public WishListDTO search(@RequestParam("query") String query) {
	    log.info("검색 요청: {}", query);
	    return wishListService.search(query);

	}
	@PostMapping("")///api/restaurant + post
	public WishListDTO add(@RequestBody WishListDTO wishListDTO) {
		log.info("wish 추가"+wishListDTO);
		return wishListService.add(wishListDTO);
	}
	@GetMapping("/all")
	public List<WishListDTO> getList(){
		log.info("wish list 요청");
		return wishListService.all();
	}
}
