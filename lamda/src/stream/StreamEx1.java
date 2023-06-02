package stream;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * ��Ʈ�� ����
 * - �پ��� ������ �̿��� ������ �۾����� ������ ó����
 * - ���� ����
 * 	1)�߰� ���� : ���� ����� ��Ʈ��
 * 				map(), filter(), skip()...
 *  2)���� ���� : ���� ����� ��Ʈ���� �ƴ� ����
 *  			forEach(), collect(), reduce(), count(), max(), min()..
 *  
 */
public class StreamEx1 {

	public static void main(String[] args) {
		// ���� ��ü���� �̸��� ���

		List<File> list = new ArrayList<File>();

		list.add(new File("c:\\file1.txt"));
		list.add(new File("c:\\file2.txt"));
		list.add(new File("c:\\file3.txt"));
		list.add(new File("c:\\file4.txt"));
		list.add(new File("c:\\file5.txt"));
		
		//�̸��� ������ �� ���
		for (File file : list) {
			System.out.println(file.getName());
		}
		//stream ���� ó��
		//stream ��ȯ (list.stream()) ->����(map()) -> ��� ���
		//map(): ��Ʈ���� ��ҿ� ����� �� �߿��� ���ϴ� �ʵ常 �����ϰų� Ư�� ��ä�� ��ȯ�� ���
//		Stream<String> names = list.stream().map(File::getName);
//		names.forEach(f-> System.out.println(f));
		
		list.stream().map(File::getName).forEach(f->System.out.println(f));
		
		List<String> fruits =Arrays.asList("melon","apple","banna","grapes");
		
		//fruits �빮�ڷ� ������ �� ���ο� ����Ʈ�� ���� ���
		
		List<String> upper = new ArrayList<String>();
		for (String string:fruits) {
			upper.add(string.toUpperCase());
		
		}for (String string : upper) {
			System.out.println(string);
		}
		
		fruits.stream().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
		System.out.println();
		fruits.stream().map(String::toUpperCase).forEach(System.out::println);
	}

}
