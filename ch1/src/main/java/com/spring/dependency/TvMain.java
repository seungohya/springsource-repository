package com.spring.dependency;

public class TvMain {
//	String str = "String";
	public static void main(String[] args) {
		
//		SonySpeaker speaker = new SonySpeaker();
//		TV tv = new SamsungTV(speaker);
//		TV tv = new SamsungTV(new SonySpeaker());
		
		//setter �� ����� ��� ���� �ʱ�ȭ
		SamsungTV tv = new SamsungTV();
		tv.setSpeaker(new SonySpeaker());
		tv.PowerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		/*
		 * TvMain obj = new TvMain(); obj.test();
		 */
	}
	
/*	public void test() {
		System.out.println(str);
		System.out.println(str.length());*/
	}


