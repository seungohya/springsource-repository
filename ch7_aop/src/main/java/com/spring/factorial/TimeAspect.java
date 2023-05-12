package com.spring.factorial;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
@Component
@Aspect(value = "execution(* com.spring.factorial..*(..))")
// aop 
// Ⱦ�ܰ��ɻ縦 ó���� �� Ŭ���� 
public class TimeAspect {
	public Object measure(ProceedingJoinPoint pjp) {
		long start = System.nanoTime();
		Object object = null;
		try {
			
			 object = pjp.proceed();//�ֵȰ��ɻ� �޼ҵ带 ȣ��
		} catch (Throwable e) {
	
			e.printStackTrace();
	
		}finally {
			long end = System.nanoTime();
			System.out.println("�ɸ��� �ð� :" +(end+start));
		}
		return object;
	}
}
