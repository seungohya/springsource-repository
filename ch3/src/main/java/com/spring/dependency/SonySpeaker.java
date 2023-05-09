package com.spring.dependency;

import org.springframework.stereotype.Component;

@Component("sony")
public class SonySpeaker implements Speaker {
	
	public SonySpeaker () {
		System.out.println("SonySpeaker �ν��Ͻ� ����");
	}

	@Override
	public void volumeUp() {
		System.out.println("SonySpeaker Volume Up");

	}

	@Override
	public void volumeDown() {
		System.out.println("SonySpeaker Volume Down");


	}

}
