package com.spring.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.spring.domain.FileDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@GetMapping("/uploadForm")
	public void uploadForm() {
		logger.info("uploadForm ��û");
	}

	// ÷������ 1���� ���
//	@PostMapping ("/uploadForm")
//	public void uploadForm(FileDTO dto) {
//		logger.info("uploadForm ��û"+dto);
//		
//		logger.info("file name" +dto.getFile().getOriginalFilename());
//		logger.info("content type" +dto.getFile().getContentType());
//		logger.info("file size" +dto.getFile().getSize());
//		String uploadPath = "C://uploads";
//		File saveFile= new File(uploadPath, dto.getFile().getOriginalFilename());
//		try {
//			//������ ����
//			dto.getFile().transferTo(saveFile);
//		} catch (IllegalStateException e) {
//			e.printStackTrace();
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
//	}
	// ÷�������� �������� ���
	@PostMapping("/uploadForm")
	public void uploadForm(FileDTO dto) {
		logger.info("uploadForm ��û" + dto);
		String uploadPath = "C://uploads";
		for (MultipartFile multipartFile : dto.getFile()) {

			logger.info("file name" + multipartFile.getOriginalFilename());
			logger.info("content type" + multipartFile.getContentType());
			logger.info("file size" + multipartFile.getSize());
			UUID uuid = UUID.randomUUID();
			String fileName = uuid.toString()+"_"+multipartFile.getOriginalFilename();
			File saveFile = new File(uploadPath, fileName);

			try {
				// ������ ����
				multipartFile.transferTo(saveFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
