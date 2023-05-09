package com.spring.dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv") //SamsungTV ��ü ����
public class SamsungTV implements TV {
	@Autowired // ���� (������ �����̳ʰ� �����ϴ� �� �߿��� �ϳ��� ���Ե�)
	@Qualifier("apple") //: ���Ե� ��ü�� �����ϴµ� ���
	private Speaker speaker;

	public SamsungTV() {
		System.out.println("SamsungTV �ν��Ͻ� ���� - default ������");
	}

	public SamsungTV(Speaker speaker) {
		super();
		this.speaker = speaker;
		System.out.println("SamsungTV �ν��Ͻ� ���� - ���� ������");
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
