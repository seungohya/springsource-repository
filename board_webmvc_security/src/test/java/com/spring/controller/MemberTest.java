package com.spring.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/security-context.xml" })
public class MemberTest {

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private DataSource ds;

	@Test
	public void test() {
		String sql = "insert into spring_member(userid, userpw, username) values (?, ?, ?)";
		for (int i = 0; i < 50; i++) {
			try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {

				
				pstmt.setString(2, encoder.encode("pw" + i));

				if (i < 20) {
					pstmt.setString(1, "user" + i);
					pstmt.setString(3, "�Ϲ�ȸ��" + i);
				} else if (i < 40) {
					pstmt.setString(1, "user" + i);
					pstmt.setString(3, "�Ŵ���" + i);
				} else {
					pstmt.setString(1, "user" + i);
					pstmt.setString(3, "������" + i);
				}
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}