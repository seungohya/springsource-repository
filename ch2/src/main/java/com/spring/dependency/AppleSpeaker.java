package com.spring.dependency;

public class AppleSpeaker implements Speaker {
	
	public AppleSpeaker () {
		System.out.println("AppleSpeaker �ν��Ͻ� ����");
	}

	@Override
	public void volumeUp() {
		System.out.println("AppleSpeaker Volume Up");

	}

	@Override
	public void volumeDown() {
		System.out.println("AppleSpeaker Volume Down");


	}

}
