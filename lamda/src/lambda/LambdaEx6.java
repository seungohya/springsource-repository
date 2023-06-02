package lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


public class LambdaEx6 {

	public static void main(String[] args) {
		//���ڿ��� �����ϴ� ��� ���� => 1
		Supplier<String> s = () ->"Hello World";
		System.out.println(s.get());
		//���ڿ��� �Է¹޾Ƽ� ���ڿ��� ���̰� 0���� �Ǵܱ�� ���� => 3
		Predicate<String> p = i -> i.length()>0;
		System.out.println(p.test("Hello World"));
		//���ڿ��� �Է¹޾Ƽ� ����ϴ� ��� ���� => 2
		Consumer<String> c = i -> System.out.println(i);
		c.accept("Hello World");
		
		//���ڿ��� �Է¹޾Ƽ� ������ ���� ��� ���� => 4
		Function<String, Integer> f = i -> Integer.parseInt(i)*40/15+5;
		System.out.println(f.apply("333"));
	}

}
