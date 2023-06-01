package com.spring.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.file.Files;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.multipart.MultipartFile;

import com.spring.domain.AttachFileDTO;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;

@Controller
@Slf4j
public class UploadAjaxController {
	@GetMapping("/uploadAjax")
	public void uploadAjaxPage() {
		// 업로드 Ajax 페이지를 보여주기 위한 메서드
	}

//	@PostMapping("/uploadAjax")
//	public ResponseEntity<String> uploadAjaxPost(MultipartFile uploadFile) {
//		log.info("upload 요청");
//
//		log.info("file name" + uploadFile.getOriginalFilename());
//		log.info("file size" + uploadFile.getSize());
//
//		String uploadPath = "c:\\uploads";
//		UUID uuid = UUID.randomUUID();
//		String fileName = uuid.toString() + "_" + uploadFile.getOriginalFilename();
//
//		try {
//			uploadFile.transferTo(new File(uploadPath, fileName));
//
//		} catch (IllegalStateException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
////		상태코드 + 메세지 보내기
//		return new ResponseEntity<>(fileName, HttpStatus.OK);
//	}
	@PostMapping("/uploadAjax")
	public ResponseEntity<List<AttachFileDTO>> uploadAjaxPost(MultipartFile[] uploadFile) {
		log.info("upload 요청");
		List<AttachFileDTO> fileList = new ArrayList<AttachFileDTO>();
		// 폴더 생성
		String uploadPath = "c:\\uploads";
		String uploadFolderPath = getFolder();
		log.info("uploadFolderPath ", uploadFolderPath);
		File uploadFullPath = new File(uploadPath, uploadFolderPath);
		if (!uploadFullPath.exists()) {
			uploadFullPath.mkdirs();
		}
		for (MultipartFile multipartFile : uploadFile) {

			log.info("file name" + multipartFile.getOriginalFilename());
			log.info("file size" + multipartFile.getSize());

			UUID uuid = UUID.randomUUID();
			String fileName = uuid.toString() + "_" + multipartFile.getOriginalFilename();
//			fileList.add(multipartFile.getOriginalFilename());

			File saveFile = new File(uploadFullPath, fileName);
			// 파일 한 개당 AttachFileDTO 생성
			AttachFileDTO attach = new AttachFileDTO();
			attach.setFileName(multipartFile.getOriginalFilename());
			attach.setUploadPath(uploadFolderPath);
			attach.setUuid(uuid.toString());
			try {
				// 원본 파일 저장
				multipartFile.transferTo(saveFile);

				// 업로드된 파일 타입 체크
				if (checkImageType(saveFile)) {
					attach.setFileType(true);
					// 이미지 파일이라면 썸네일 이미지로 저장
					// 원본 이미지 읽어오기
					BufferedImage origin = ImageIO.read(saveFile);
					// 썸네일 파일명
					File thumbnail = new File(uploadFullPath, "s_" + fileName);

					double ratio = 10; // 축소비율
					int width = (int) (origin.getWidth() / ratio);
					int height = (int) (origin.getHeight() / ratio);

					Thumbnails.of(origin).size(width, height).toFile(thumbnail);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			fileList.add(attach);
		}
//		상태코드 + 메세지 보내기
		return new ResponseEntity<>(fileList, HttpStatus.OK);
	}

	// 파일 요청이 오면 파일 보내주기
	@GetMapping("/display")
	public ResponseEntity<byte[]> getFile(String fileName) {
		log.info("파일 요청" + fileName);
		File file = new File("c:\\uploads\\" + fileName);
		// speingframework Headers
		HttpHeaders headers = new HttpHeaders();
		ResponseEntity<byte[]> result = null;
		try {
			headers.add("content-type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file), HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	@GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<Resource> downloadFile(String fileName, @RequestHeader("User-Agent") String userAgent) {
		log.info("파일 다운로드 요청 " + fileName);
		
		Resource resource = new FileSystemResource("c:\\uploads\\" + fileName);
		String oriFileName = fileName.substring(fileName.indexOf("_")+1);

		if (!resource.exists()) {
			return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);

		}
		HttpHeaders headers = new HttpHeaders();
		String downloadName = null;
		try {
			//ms 계열 : Trident (IE 11) 하기 브라우저인 경우에는 공백을 \\ <- 이걸로 변경해줘라는뜻의 코드
			if (userAgent.contains("Trident") || userAgent.contains("Edge")) {
				downloadName = URLEncoder.encode(oriFileName, "utf-8").replaceAll("\\+", "");
			} else {
				downloadName = new String(oriFileName.getBytes("utf-8"), "ISO-8859-1");

			}
			//실제로 다운로드를 실행하는 파일을 헤더에 붙이는 코드
			headers.add("Content-Disposition", "attachment;filename=" + downloadName);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}
	

	@PostMapping("/deleteFile")
	public ResponseEntity<String> deleteFile(String fileName, String type){
	    log.info("파일 제거 요청: " + fileName + ", type: " + type);
	    try {
	        File file = new File("c:\\uploads\\", URLDecoder.decode(fileName, "utf-8"));
	        file.delete(); // 파일 삭제 txt, 썸네일 삭제

	        if (type.equals("image")) {
	            String originalFileName = file.getAbsolutePath().replace("s_", "");
	            file = new File(originalFileName);
	            file.delete();
	        }

	        ObjectMapper objectMapper = new ObjectMapper();
	        String jsonResponse = objectMapper.writeValueAsString("success");
	        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);

	    } catch (UnsupportedEncodingException e) {
	        e.printStackTrace();
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    } catch (IOException e) {
	        e.printStackTrace();
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}


	// 일반 메소드 (파일 타입 확인)
	private boolean checkImageType(File file) {
		String contentType;
		try {
			contentType = Files.probeContentType(file.toPath());
			return contentType.startsWith("image");

		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	// 일반 메소드 (폴더 생성)
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();// 날짜 정보가 길게
		String folder = sdf.format(date);// 2023-05-26
		return folder.replace("-", File.separator);// c:/1.jsp
	}
}