package com.team6.leangoo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = "com.team6.leangoo.mapper")
public class LeangooApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeangooApplication.class, args);
	}
}
