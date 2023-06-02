package stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/*
 * ��Ʈ�� 
 * - �÷��� (List, Set) ��ῡ �����͸� ��� ���ϴ� ����� ���� ���� for���� Iterator �� �����
 *  ==> ������ ���� �ٸ� ������� �ٷ�� �� , ���뼺 ������, ���� ����� �޼ҵ���� �ߺ����� ����
 *  ==> List ���� �� Collections.sort() ���, �迭 ���� Arrays.sort()
 *  
 *  ==> ���� ������ �ذ��ϱ� ���� ��Ʈ���� �߰���
 *  ==> �����Ͱ� ���� �ٸ� �����Ͷ� ������ ������� ó��
 *  ==> Ư¡
 *	==> 1) ������ �ҽ��� �������� ����
 *	==> 2) ��Ʈ���� ��ȸ��
 *	==> 3) ��Ʈ���� �۾��� ���� �ݺ����� ó��
 *  
 */
public class ForEach1 {

	public static void main(String[] args) {
		// ���ڿ� �迭
		String[] strArr = { "aaa", "ddd", "ccc" };
		// ���ڿ� ����Ʈ
		List<String> strList = Arrays.asList(strArr);
		// ���� + ���
		Arrays.sort(strArr); //���� ����
		for (String string : strList) {
			System.out.println(string + " ");
		}
		
		System.out.println();
		System.out.println("\n-----------------------stream");
		
		Collections.sort(strList);//���� ����
		for (String string : strList) {
			System.out.println(string + " ");
		}
		//Stream ���
		String[] strArr1 = { "aaa", "ddd", "ccc" };
		List<String> strList1 = Arrays.asList(strArr1);
		
		//1.��Ʈ���� ����
		Stream<String> stream1 = Arrays.stream(strArr1);
		Stream<String> stream2 = strList1.stream();
		
		//2. ���� + ���
		stream1.sorted().forEach(System.out::println);
		stream2.sorted().forEach(System.out::println);
		
		//3. ����? �״�� ����
		System.out.println("���� ������");
		System.out.println(Arrays.toString(strArr1));
		System.out.println(strList1);
	}

}
