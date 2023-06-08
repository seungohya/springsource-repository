package com.spring.schedule;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.spring.domain.AttachFileDTO;
import com.spring.mapper.AttachMapper;

@Component
public class TaskTest {
	@Autowired
	private AttachMapper mapper;
//	<ul>
//	 <li>second</li>
//	 <li>minute</li>
//	 <li>hour</li>
//	 <li>day of month</li>
//	 <li>month</li>
//	 <li>day of week</li>
//	 </ul>

	@Scheduled(cron = "0 0 2 * * *")
	public void schedulerTest() {

		// 데이터베이스 어제 날짜의 파일 목록 가져오기
		List<AttachFileDTO> oldList = mapper.oldFiles();
//		List<Path> pathList = new ArrayList<Path>();
//		for (AttachFileDTO dto : oldList) {
//			Path path = Paths
//					.get("c:\\uploads\\" + dto.getUploadPath() + "\\" + dto.getUuid() + "_" + dto.getFileName());
//			pathList.add(path);
//			if (dto.isFileType()) {
//				Path thumb = Paths
//						.get("c:\\uploads\\" + dto.getUploadPath() + "\\s_" + dto.getUuid() + "_" + dto.getFileName());
//				pathList.add(thumb);
//			}
//		}
		// oldList 를 stream 변환,
		List<Path> pathList = oldList.stream()
				.map(dto -> Paths
						.get("c:\\uploads\\" + dto.getUploadPath() + "\\" + dto.getUuid() + "_" + dto.getFileName()))
				.collect(Collectors.toList());

		oldList.stream().filter(null)
				.map(dto -> Paths
						.get("c:\\uploads\\" + dto.getUploadPath() + "\\s_" + dto.getUuid() + "_" + dto.getFileName()))
				.forEach(dto -> pathList.add(dto));
		System.out.println(pathList);
		
		
		// 어제날짜 구해서 폴더에 접근한 후 폴더에 있는 파일 목록 가져오기
		String yesterday = getFolderYesterDay();
		File targetDir = Paths.get("c:\\uploads", yesterday).toFile();
		System.out.println("targetDir" + targetDir);

		// 비교후 일치하지 않은 파일은 삭제
		File[] removeFiles = targetDir.listFiles(f -> pathList.contains(f.toPath()) == false);
		for (File remove : removeFiles) {
			remove.delete();
		}
	}

	private String getFolderYesterDay() {
		// 어제 날짜 추출
		LocalDate yesterday = LocalDate.now().minusDays(1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy\\MM\\dd");
		String folderPath = yesterday.format(formatter);
		return folderPath.replace("-", File.separator);
	}

//    @Scheduled(fixedDelay = 10000)
//    public void schedulerTest2() {
//        System.out.println("매 10초마다 스케줄링...");
//    }
}
