package com.spring.dependency;

public class SamsungTV implements TV {

	private Speaker speaker = new SonySpeaker();

	public SamsungTV() {

	}

	public SamsungTV(Speaker speaker) {
		super();
		this.speaker = speaker;
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	@Override
	public void PowerOn() {
		System.out.println("SamsungTV - �Ŀ� On");
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV - �Ŀ� Off");
	}

	@Override
	public void volumeUp() {
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
		speaker.volumeDown();
	}
}
