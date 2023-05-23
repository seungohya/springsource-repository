package com.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.javassist.tools.reflect.Sample;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.domain.SampleDTO;

@RestController
public class RestControllerTest {
	// 일반컨트롤러에서 return 값은 view 이름
	// Rest 컨트롤러에서 return 값은 데이터
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World";
	}

	// 리턴 값을 json 형태로 보낸다는 의미
	// 자바 객체 => json 형태로 변경해주는 라이브러리가 필요하다.
	@GetMapping(value = "/send", produces = MediaType.APPLICATION_JSON_VALUE)
	public SampleDTO sendDto() {
		return new SampleDTO("1234", "홍", "길동");
	}

	@GetMapping(value = "/sends", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SampleDTO> sendList() {
		List<SampleDTO> list = new ArrayList<SampleDTO>();
		list.add(new SampleDTO("1234", "홍", "길동"));
		list.add(new SampleDTO("1235", "박", "길동"));
		list.add(new SampleDTO("1236", "김", "길동"));
		list.add(new SampleDTO("1237", "최", "길동"));
		return list;
	}

	// ResponseEntity : 상태코드(200,400,500 )와 데이터 같이 전송
	@GetMapping(value = "/check1", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SampleDTO> chekc(double height, double weight) {
		SampleDTO dto = new SampleDTO("1234", "" + height, "" + weight);
		ResponseEntity<SampleDTO> entity = null;
		if (height < 160) {
			entity = new ResponseEntity<SampleDTO>(dto, HttpStatus.BAD_REQUEST);
		} else {
			entity = new ResponseEntity<SampleDTO>(dto, HttpStatus.OK);
		}
		return entity;
	}
	//경로에 있는 특정 값을 사용하고 싶다면?
	// http://localhost:8080/product/bags/1001 만약 이렇게 주소요청이 온다면
	//bags (카테고리명) , 1001 (상품아이디) 
	//@pathVariable 어노테이션을 사용해서 반복해서 사용하는 경로를 변수에 담아 관리가능
	@GetMapping ("/product/{cat}/{pid}")  //cat 과 pid 라는 변수명을 선언해주고 값을 담을 수 있다.
	public String [] getPath (@PathVariable("cat") String cat ,@PathVariable("pid") String pid) {
		return new String [] {
				"category: "+cat, "productId : " + pid
		};
	}

}
