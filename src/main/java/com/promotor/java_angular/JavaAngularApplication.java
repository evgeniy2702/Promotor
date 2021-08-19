package com.promotor.java_angular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;


@SpringBootApplication(scanBasePackages = "com.promotor.java_angular")
@EntityScan("com.promotor.java_angular.model")
public class JavaAngularApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaAngularApplication.class, args);
	}


	@Bean
	public ServletWebServerFactory servletWebServerFactory() {
		return new TomcatServletWebServerFactory();
	}

}
