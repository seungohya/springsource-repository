package com.spring.factorial;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//AOP : Ⱦ�ܰ��ɻ� �����ӿ�ũ�� ó��

//�ֵ� ���ɻ� : factorial ���ϱ�
//Ⱦ�ܰ��ɻ� : ���� �� ���� ���ΰ�? �ð��� �󸶳� �ɸ�����
public class FactMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		Calculator cal = (Calculator) ctx.getBean("rec");
		System.out.println("=================");
		System.out.println("10!= "+ cal.factorial(10));
		
		cal = (Calculator)ctx.getBean("forc");
		System.out.println("=================");
		System.out.println("10!= "+ cal.factorial(10));

	}

}
