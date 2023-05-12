package com.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// Ⱦ�ܰ��ɻ縦 ó���� �� Ŭ����
// Ⱦ�ܰ��ɻ縦 ���� ó���� ���ΰ�?
// Before(�޼ҵ� ȣ�� ����), After returning(�޼ҵ� ȣ�� ���Ŀ�), After throwing(�޼ҵ� ���� �߻� ��)
// After(�޼ҵ� ȣ�� �� ���� �߻� ���ο� �������), Around(�޼ҵ� ȣ�� ������ ���� ��� ����)

@Component("log")
@Aspect
public class LogAdvice {
	
	// execution() : ǥ���� : Ư�� �޼ҵ常 advice �� ��
	// * : ����Ÿ��
	// com.spring.aop : ��Ű����
	// Product : Ŭ������
	// getInfo() : �޼ҵ��
	
	
//	@Before(value = "execution(* com.spring.aop.Product.getInfo())")
//	public void beforeLog() {
//		System.out.println("[����α�] ����Ͻ� ���� ���� �� ȣ��");
//	}
	
	
//	@After(value = "execution(* com.spring.aop.Product.getInfo())")
//	public void afterLog() {
//		System.out.println("[����α�] ����Ͻ� ���� ���� �� ȣ�� ��(���� �߻� ���ο� ������� ������ ����");
//	}
	
//	@AfterThrowing(value = "execution(* com.spring.aop.Product.getInfo())")
//	public void afterThrowingLog() {
//		System.out.println("[����α�] ����Ͻ� ���� ���� �� ���� �߻� �� ȣ�� ��");
//	}
	
//	@AfterReturning(value = "execution(* com.spring.aop.Product.getInfo())")
//	public void afterReturnLog() {
//		System.out.println("[����α�] ����Ͻ� ���� ���� �� ���ܹ߻� ���� ���� ȣ�� ��");
//	}
	
	
	@Around(value = "execution(* com.spring.aop.Product.getInfo())")
	public void aroundLog(ProceedingJoinPoint pjp) {
		System.out.println("[����α�] ����Ͻ� ���� ���� �� ȣ�� ��");
		try {
			pjp.proceed(); //ó���ؾ� �ϴ� �޼ҵ� ȣ���
		} catch (Throwable e) {			
			e.printStackTrace();
		}
		System.out.println("[����α�] ����Ͻ� ���� ���� �� ȣ�� ��");
	}
}














