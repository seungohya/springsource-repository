package lambda;

public class LambdaEx2 {

	public static void main(String[] args) {
		//Lamda2 interface를 사용하고 싶다면?
		//1) 구현 클래스 작성 implements Lamda2
		//2) 익명 구현 클래스 작성
//		Lamda2 lambda = new Lamda2() {
//			
//			@Override
//			public void method() {
//				System.out.println("익명 구현 클래스");
//				
//			}
//		};
//		lambda.method();
		Lambda2 lambda = () -> System.out.println("익명 구현 클래스");
		lambda.method();
		
		lambda =()->{
			int i =10;
			System.out.println(i*i);
		}; lambda.method();
	}

}
