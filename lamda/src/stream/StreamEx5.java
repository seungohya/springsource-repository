package stream;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
//최종연산
//count(), max(), min(), average()m findFirst(),sum()
public class StreamEx5 {

	public static void main(String[] args) {
		//int => stream
		IntStream stream1 = Arrays.stream(new int[] {1,4,6,8,9});
		//2의 배수는 몇 개?
//		stream1.filter(s -> s %2 ==0).forEach(System.out::println);
		//스트림은 일회용이기 때문에 한번 사용하면 닫히기에 사용불가하다.
		System.out.println(stream1.filter(s -> s %2 ==0).count());
		stream1 = Arrays.stream(new int[] {1,4,6,8,9});//그래서 이렇게 다시 코드 작성
		System.out.println(stream1.filter(s -> s %2 ==0).sum());
		
		stream1 = Arrays.stream(new int[] {1,4,6,8,9});
		System.out.println(stream1.filter(s -> s %2 ==0).average());
		stream1 = Arrays.stream(new int[] {1,4,6,8,9});
		System.out.println(stream1.filter(s -> s %2 ==0).max());
		stream1 = Arrays.stream(new int[] {1,4,6,8,9});
		System.out.println(stream1.filter(s -> s %2 ==0).min());
		stream1 = Arrays.stream(new int[] {1,4,6,8,9});
		System.out.println("2의 배수 첫번째 값 : "+stream1.filter(s -> s %2 ==0).findFirst());
		
	
	}
}
