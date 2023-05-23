package com.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.domain.SampleDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("index");

		
		return "index";

	}
	@ResponseBody
	@GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
	public SampleDTO sendDto() {
		return new SampleDTO("1234", "ȫ", "�浿");
	}
	@GetMapping(value = "/check", produces = MediaType.APPLICATION_JSON_VALUE)
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
}
