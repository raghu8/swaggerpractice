package com.raghu.swaggerapp.swaggerpractice.swaggerconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	// Create an instance of Docket. Has all customizable properties that swagger
	// will pick up
	@Bean
	public Docket api() {
		//Step 1. Call select
		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.ant("/*")).build();
//		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
//				.paths(PathSelectors.any()).build();
	}

	private Predicate<String> postPaths() {
		return or(regex("/hello.*"), regex("/hello.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Swagger Example").description(
				"Swagger is an open source software framework that helps developers design, build, document, and consume RESTful Web services. Basically it's provide the description/documentation of your Restful Web Service.")
				.termsOfServiceUrl("http://localhost:8080/swagger-ui.html").licenseUrl("a@b.com").version("1.0")
				.build();
	}

}