package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.domain.AddDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CalcController {
	@GetMapping("/add")
	public void addForm() {
		log.info("add 요청");
	}
	//사용자 입력 값 가져오기
		//1.HttpServletRequest 사용하기
		//2.변수사용 : 변수명은 폼 태그 name 과 일치 2) 폼 태그 name 과 일치하지 않을 때 @RequestParam 사용
		//3.바인딩 객체 사용 
//	@PostMapping("/add")
//	public void addPost (int num1 , int num2 ) {
//		log.info("add Post 요청");
//		log.info("num1"+num1);
//		log.info("num2"+num2);
//		log.info("result"+(num1+num2));
//	}
//	@PostMapping("/add")
//	public void addPost (AddDTO dto) {
//		log.info("add Post 요청");
//		log.info("num1"+dto.getNum1());
//		log.info("num2"+dto.getNum2());
//		log.info("result"+(dto.getNum2()+dto.getNum1()));
//	}
	@PostMapping("/add")
	public String addPost (AddDTO dto,@ModelAttribute("page") String page, Model model) {
		log.info("add Post 요청");
		log.info("num1"+dto.getNum1());
		log.info("num2"+dto.getNum2());
		log.info("page"+page);
		int result =dto.getNum2()+dto.getNum1();
		log.info("result"+result);
	    model.addAttribute("result", result); 
	    //model.addAttribute("page", page); 
	    //result 값을 result.jsp 에서 사용하기 위해서
	    //model 객체를 사용해서 request.setAttribute() 와 같은 역할을 수행
		return "result";//view resolve 가 돌면서 /WEB-INF/views/result.jsp 자동으로 해줌
	}
}
