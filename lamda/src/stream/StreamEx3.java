package stream;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx3 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("�ٵ�", "�ٳ���", "����", "����", "����", "������");

		// "��"�� �����ϴ� ��Ҹ� ���ο� ����Ʈ�� �߰� �� ���
		// filter (): ��Ʈ�� ��� �ɷ�����
		list.stream().filter(s -> s.startsWith("��")).forEach(System.out::println);

		List<Student> stuList = new ArrayList<>();
		stuList.add(new Student("ȫ�浿", 99));
		stuList.add(new Student("��浿", 89));
		stuList.add(new Student("��浿", 79));
		stuList.add(new Student("�ڱ浿", 49));

		stuList.stream().filter(s -> s.getName().startsWith("��")).forEach(s -> System.out.println(s.getName()));
		//distinct(): �ߺ� ����
		List<String> list1 = Arrays.asList("�ٵ�", "�ٳ���", "����", "����", "����", "������", "�ٵ�", "�ٳ���", "����", "����", "����");
		list1.stream().distinct().forEach(System.out::println);
		//Arrays.asList(...) : array => list
		//Stream.of(...) : array => stream
		Stream<File> stream = Stream.of(new File("d:\\test1.txt"), new File("d:\\test2.txt"), new File("d:\\test3.txt"),
				new File("d:\\test.java"), new File("d:\\test"), new File("d:\\test6.bak"));
		//���� Ȯ���� ������ �� �ߺ��� �����ϰ� ����ϱ�
		//���� �̸� ����. -> Ȯ���� ���� ->Ȯ���ڸ� ���� ->�ߺ����� -> ���
		stream.map(f -> f.getName().substring(f.getName().lastIndexOf("."))).distinct().forEach(System.out::println);
		
	}
}
