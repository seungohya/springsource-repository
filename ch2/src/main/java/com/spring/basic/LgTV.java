package com.spring.basic;

public class LgTV implements TV{
	@Override
	public void volumeUp() {
		System.out.println("LGTV - ���� Up");
	}
	@Override
	public void volumeDown() {
		System.out.println("LGTV - ���� Down");
	}

	@Override
	public void PowerOn() {
		System.out.println("LGTV - ���� On");
		
	}

	@Override
	public void powerOff() {
		System.out.println("LGTV - ���� Off");
		
	}
}
