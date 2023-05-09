package com.spring.dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv") //SamsungTV 객체 생성
public class SamsungTV implements TV {
	@Autowired // 주입 (스프링 컨테이너가 관리하는 빈 중에서 하나가 주입됨)
	@Qualifier("apple") //: 주입될 객체를 구분하는데 사용
	private Speaker speaker;

	public SamsungTV() {
		System.out.println("SamsungTV 인스턴스 생성 - default 생성자");
	}

	public SamsungTV(Speaker speaker) {
		super();
		this.speaker = speaker;
		System.out.println("SamsungTV 인스턴스 생성 - 인자 생성자");
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	@Override
	public void PowerOn() {
		System.out.println("SamsungTV - 파워 On");
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV - 파워 Off");
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
