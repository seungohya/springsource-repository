package stream;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
//��������
//count(), max(), min(), average()m findFirst(),sum()
public class StreamEx5 {

	public static void main(String[] args) {
		//int => stream
		IntStream stream1 = Arrays.stream(new int[] {1,4,6,8,9});
		//2�� ����� �� ��?
//		stream1.filter(s -> s %2 ==0).forEach(System.out::println);
		//��Ʈ���� ��ȸ���̱� ������ �ѹ� ����ϸ� �����⿡ ���Ұ��ϴ�.
		System.out.println(stream1.filter(s -> s %2 ==0).count());
		stream1 = Arrays.stream(new int[] {1,4,6,8,9});//�׷��� �̷��� �ٽ� �ڵ� �ۼ�
		System.out.println(stream1.filter(s -> s %2 ==0).sum());
		
		stream1 = Arrays.stream(new int[] {1,4,6,8,9});
		System.out.println(stream1.filter(s -> s %2 ==0).average());
		stream1 = Arrays.stream(new int[] {1,4,6,8,9});
		System.out.println(stream1.filter(s -> s %2 ==0).max());
		stream1 = Arrays.stream(new int[] {1,4,6,8,9});
		System.out.println(stream1.filter(s -> s %2 ==0).min());
		stream1 = Arrays.stream(new int[] {1,4,6,8,9});
		System.out.println("2�� ��� ù��° �� : "+stream1.filter(s -> s %2 ==0).findFirst());
		
	
	}
}
