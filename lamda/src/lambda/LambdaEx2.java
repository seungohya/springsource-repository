package lambda;

public class LambdaEx2 {

	public static void main(String[] args) {
		//Lamda2 interface�� ����ϰ� �ʹٸ�?
		//1) ���� Ŭ���� �ۼ� implements Lamda2
		//2) �͸� ���� Ŭ���� �ۼ�
//		Lamda2 lambda = new Lamda2() {
//			
//			@Override
//			public void method() {
//				System.out.println("�͸� ���� Ŭ����");
//				
//			}
//		};
//		lambda.method();
		Lambda2 lambda = () -> System.out.println("�͸� ���� Ŭ����");
		lambda.method();
		
		lambda =()->{
			int i =10;
			System.out.println(i*i);
		}; lambda.method();
	}

}
