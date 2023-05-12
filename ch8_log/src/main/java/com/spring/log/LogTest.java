package com.spring.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class LogTest {
	private static final Logger logger = LoggerFactory.getLogger(LogTest.class);
	
	public static void main(String[] args) {
		logger.error("error ����");
		logger.warn("warn ����");
		logger.info("info ����");
		logger.debug("debug ����");
		logger.trace("trace ����");

	}

}
