package stream;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx2 {
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList("사과", "바나나", "오렌지", "포도", "딸기", "망고", "수박", "파인애플", "체리", "바나나", "수박", "사과");
		list.stream().skip(2).limit(3).forEach(System.out::println);
	}
}
