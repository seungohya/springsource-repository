package stream;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx2 {
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList("���", "�ٳ���", "������", "����", "����", "����", "����", "���ξ���", "ü��", "�ٳ���", "����", "���");
		list.stream().skip(2).limit(3).forEach(System.out::println);
	}
}
