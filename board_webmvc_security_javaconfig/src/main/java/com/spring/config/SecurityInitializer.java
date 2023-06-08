package com.spring.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {
    // 이 클래스는 빈 내용으로 남겨둡니다.
    // AbstractSecurityWebApplicationInitializer를 상속받기 때문에 자동으로 springSecurityFilterChain 필터가 등록됩니다.
    // 다른 설정은 필요하지 않습니다.
}
