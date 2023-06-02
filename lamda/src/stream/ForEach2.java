package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ForEach2 {

	 public static void main(String[] args) {
	        List<String> list = Arrays.asList("A", "B", "C", "D", "E");

	        list.forEach(item -> System.out.println(item));

	        List<Student> stuList = new ArrayList<>();
	        stuList.add(new Student("홍길동", 99));
	        stuList.add(new Student("고길동", 89));
	        stuList.add(new Student("김길동", 79));
	        stuList.add(new Student("박길동", 49));

	        stuList.forEach(student -> System.out.println(student.getName() + " : " + student.getJumsu()));
	        System.out.println("---------------------------------------");
	        for (Student student : stuList) {
	            System.out.println(student.getName() + " : " + student.getJumsu());
	        }

	        Map<String, Integer> map = new HashMap<>();
	        map.put("A", 10);
	        map.put("B", 20);
	        map.put("C", 30);
	        map.put("D", 50);
	        map.put("E", 60);
	        map.put("F", 70);

	        for (Map.Entry<String, Integer> entry : map.entrySet()) {
	            System.out.println("Item: " + entry.getKey() + ", Count: " + entry.getValue());
	        }
		System.out.println();
		
		map.forEach((k,v) -> System.out.println("Item : "+k+", Count: "+v));
		
		//key 값이 E 일 때 hello , E 출력문을 추가
		map.forEach((k,v)->{
			System.out.println("Item :"+k+", Count : "+v);
			if("E".equals(k)) {
				System.out.println("hello, E");
			}
		});
	}

}
