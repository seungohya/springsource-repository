package com.spring.factorial;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
@Component
@Aspect(value = "execution(* com.spring.factorial..*(..))")
// aop 
// 횡단관심사를 처리해 줄 클래스 
public class TimeAspect {
	public Object measure(ProceedingJoinPoint pjp) {
		long start = System.nanoTime();
		Object object = null;
		try {
			
			 object = pjp.proceed();//주된관심사 메소드를 호출
		} catch (Throwable e) {
	
			e.printStackTrace();
	
		}finally {
			long end = System.nanoTime();
			System.out.println("걸리는 시간 :" +(end+start));
		}
		return object;
	}
}
