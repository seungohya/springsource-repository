package stream;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx4 {

	public static void main(String[] args) {

		List<Student> stuList = new ArrayList<>();
		stuList.add(new Student("홍길동", 99));
		stuList.add(new Student("고길동", 89));
		stuList.add(new Student("김길동", 79));
		stuList.add(new Student("박길동", 49));

		List<Integer> jumsuList = stuList.stream().map(stu -> stu.getJumsu()).collect(Collectors.toList());
		jumsuList.forEach(System.out::println);
		//새로운 리스트에 과일명 대문자로 수집하기
		List<String> list = Arrays.asList("Apple", "Banana", "Orange", "Grape", "Strawberry", "Mango", "Watermelon", "Pineapple", "Cherry", "Kiwi");

		List<String> FRUITS = list.stream().map(f -> f.toUpperCase()).collect(Collectors.toList());
		System.out.println(FRUITS);
	}
}
