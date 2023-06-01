package com.spring.config;


import javax.sql.DataSource;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
@MapperScan("com.spring.mapper")
@Configuration //환경설정 클래스라는 어노테이션
@ComponentScan("com.spring.service")
public class RootConfig {
	//root-context.xml 대신으로 사용
	@Bean
	public DataSource dataSource() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("oracle.jdbc.OracleDriver" ); 
		hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe" ); 
		hikariConfig.setUsername("javadb"); 
		hikariConfig.setPassword("1234"); 

		HikariDataSource dataSource = new HikariDataSource(hikariConfig);
		return dataSource;
		
	}
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
	    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
	    sqlSessionFactoryBean.setDataSource(dataSource());
	    return sqlSessionFactoryBean.getObject();
	}

}
