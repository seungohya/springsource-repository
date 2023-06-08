package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.domain.Criteria;
import com.spring.domain.ReplyDTO;
import com.spring.domain.ReplyPageDTO;
import com.spring.service.ReplyService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/replies")
public class ReplyController {
	@Autowired
	private ReplyService reService;
	@GetMapping(value ="/{rno}")
	public ResponseEntity<ReplyDTO> get(@PathVariable("rno") int rno){
		log.info("¥Ò±€¡∂»∏"+rno);
		return new ResponseEntity<ReplyDTO>(reService.reRead(rno),HttpStatus.OK);
	}
	@PostMapping(value ="/new")
	@PreAuthorize ("isAuthenticated()")
	public ResponseEntity<String> create(@RequestBody ReplyDTO dto){
		log.info("¥Ò±€ ª¿‘" + dto );
		return reService.reInsert(dto)?
				new ResponseEntity<String>("success",HttpStatus.OK):
					new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@GetMapping(value = "/pages/{bno}/{page}")
	public ResponseEntity<ReplyPageDTO>select (@PathVariable ("bno") int bno,@PathVariable ("page")int page){
		log.info("¥Ò±€ ¡∂»∏"+bno);
		Criteria cri = new Criteria(page,10);
		return new ResponseEntity<ReplyPageDTO>(reService.reList(cri,bno),HttpStatus.OK);
	}
	//http://localhost:8080/replies/rno+ put + ºˆ¡§µ•¿Ã≈Õ (json)
	@PutMapping(value  = "/{rno}")
	@PreAuthorize ("principal.username == #dto.replyer")
	public ResponseEntity<String> modify (@RequestBody ReplyDTO dto)
	{log.info("¥Ò±€ ºˆ¡§"+ dto);
	return reService.reUpdate(dto)?
			new ResponseEntity<String>("success",HttpStatus.OK):
				new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	//http://localhost:8080/replies/rno + delete  ¥Ò±€ ªË¡¶
	@DeleteMapping(value = "/{rno}")
	@PreAuthorize ("principal.username == #dto.replyer")
	public ResponseEntity<String> delete(@PathVariable("rno") int rno, @RequestBody ReplyDTO dto){
		log.info("¥Ò±€ ªË¡¶ ø‰√ª "+rno);
		return reService.reDelete(rno)?
				new ResponseEntity<String>("success",HttpStatus.OK):
					new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
