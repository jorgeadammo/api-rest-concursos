package com.jorgeadammo.sistemas.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
	@Bean
	public Docket concursosApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.jorgeadammo.sistemas"))
				.paths(regex("/api-cnc.*"))
				.build()
				.apiInfo(metaInfo());
	}

	private ApiInfo metaInfo() {
		@SuppressWarnings("deprecation")
		ApiInfo apiInfo = new ApiInfo(
				"Spring Boot Swagger Example",
				"Spring Boot Swagger Example for API REST CONCURSOS",
				"1.0", 
				"Terms of service",
						"Jorge A Barros", 
						"http://www.jadammo.com", 
						"jorgeadammo@gmail.com");
		return apiInfo;
	}

}
