package com.authorizationservice.authorization;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class AuthorizationApplication {

	/**
	 * Main function
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(AuthorizationApplication.class, args);
	}

	
	/**
	 * Swagger Configuration
	 * @return Docket
	 */
	@Bean
	public Docket configureSwagger2(){
		return new Docket(DocumentationType.SWAGGER_2);
//					.select()
//					.apis(RequestHandlerSelectors.basePackage("com.authorizationservice.authorization"))
//					.paths(PathSelectors.any()).build().apiInfo(apiInfo());
//	}
	}
	
	/**
	 * Api Information
	 * @return ApiInfo
	 */
//	private ApiInfo apiInfo(){
//		return new ApiInfo(
//				"Authorization Module",
//				"Return Order Management Microservice",
//				"1.0",
//				"sscp - Programmer Analyst Trainee || Full Stack ...in.linkedin.com",
//				new Contact("sscp", "something.com","sscp.anything@cognizant.com"),
//				"FSE", "https://hello.sscp.com",
//				Collections.emptyList()
//		);
//	}

}