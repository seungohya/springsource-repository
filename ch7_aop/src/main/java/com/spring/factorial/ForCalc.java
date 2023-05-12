package com.spring.factorial;


import org.springframework.stereotype.Component;

@Component("forc")
public class ForCalc implements Calculator {
//for������ ������
	@Override
	public long factorial(long num) {

		int factorial = 1;
		for (int i = 1; i <= num; i++) {
			factorial *= i;
		}

		System.out.println("���丮�� ���: " + factorial);

		return factorial;
	}
}
