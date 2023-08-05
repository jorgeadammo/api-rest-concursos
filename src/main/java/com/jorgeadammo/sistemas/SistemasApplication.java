package com.jorgeadammo.sistemas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(scanBasePackages = "com.jorgeadammo.sistemas")
@EnableJpaRepositories(basePackages = "com.jorgeadammo.sistemas.repository")
@EntityScan(basePackages = "com.jorgeadammo.sistemas.entity")
@EnableTransactionManagement
@EnableAutoConfiguration
public class SistemasApplication extends SpringBootServletInitializer  {
	
	public static void main(String[] args) {
		SpringApplication.run(SistemasApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SistemasApplication.class);
	}
	
	@GetMapping("/test")
	public String test() {
		return "Application Deployed";
	}
}

