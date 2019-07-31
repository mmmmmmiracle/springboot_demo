package com.hyd.mercury;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

//@SpringBootApplication
//public class Application extends SpringBootServletInitializer {
// 
// 
//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);
//	}
//	
//	/**
//	   * 需要把web项目打成war包部署到外部tomcat运行时需要改变启动方式
//	   */
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		return builder.sources(Application.class);
//	}
// 
// 
//}