package com.chengjingwen;

 
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * member系统启动类
 * @author tangc
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class MemberServer {

	public static void main(String[] args) {
		SpringApplication.run(MemberServer.class, args);
	}
	
}
