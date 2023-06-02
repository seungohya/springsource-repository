package lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*
 * java.util.Function ���� �����ϴ� �Լ��� �������̽�
 * 1) Supplier<T> T get() : ���ϰ��� �ְ� , �Ű����� ����
 * 2) Consumer<T> void accept (T t) : ���� �޾Ƽ� ����ϴ� ����
 * 3) Predicate<T> boolean test(T t) : ���� �޾Ƽ� ���ǽĿ� ���� ��� ��ȯ 
 * 4) Function<T, R> R apply (T t) : ���� �޾Ƽ� ����� ��ȯ
 * 
 * �Ż������� 2���� �Լ��� �������̽� 
 * BiConsumer<T, U>, BiPredicate<T, U>....
 */
public class LambdaEx5 {

	public static void main(String[] args) {
		Supplier<Integer> s = () -> (int) (Math.random() * 100) + 1;
		System.out.println(s.get());

		Consumer<Integer> c = i -> System.out.println(i + "");
		c.accept(300);

		Predicate<Integer> p = i -> i > 10;
		System.out.println(p.test(50));
		
		//T : �Ű����� Ÿ�� , R : ���� Ÿ�� 
		Function<Integer, Integer> f= i -> i/10*10;
		System.out.println( f.apply(561));
	}

}
