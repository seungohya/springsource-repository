package stream;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx3 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("바둑", "바나나", "포도", "딸기", "바질", "강아지");

		// "바"로 시작하는 요소를 새로운 리스트에 추가 후 출력
		// filter (): 스트림 요소 걸러내기
		list.stream().filter(s -> s.startsWith("바")).forEach(System.out::println);

		List<Student> stuList = new ArrayList<>();
		stuList.add(new Student("홍길동", 99));
		stuList.add(new Student("고길동", 89));
		stuList.add(new Student("김길동", 79));
		stuList.add(new Student("박길동", 49));

		stuList.stream().filter(s -> s.getName().startsWith("김")).forEach(s -> System.out.println(s.getName()));
		//distinct(): 중복 제거
		List<String> list1 = Arrays.asList("바둑", "바나나", "포도", "딸기", "바질", "강아지", "바둑", "바나나", "포도", "딸기", "바질");
		list1.stream().distinct().forEach(System.out::println);
		//Arrays.asList(...) : array => list
		//Stream.of(...) : array => stream
		Stream<File> stream = Stream.of(new File("d:\\test1.txt"), new File("d:\\test2.txt"), new File("d:\\test3.txt"),
				new File("d:\\test.java"), new File("d:\\test"), new File("d:\\test6.bak"));
		//파일 확장자 추출한 후 중복을 제거하고 출력하기
		//파일 이름 수집. -> 확장자 추출 ->확장자만 모음 ->중복제거 -> 출력
		stream.map(f -> f.getName().substring(f.getName().lastIndexOf("."))).distinct().forEach(System.out::println);
		
	}
}
