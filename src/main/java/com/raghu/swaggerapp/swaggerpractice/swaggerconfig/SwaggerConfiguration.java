package com.raghu.swaggerapp.swaggerpractice.swaggerconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {


	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api").apiInfo(apiInfo()).select()
				.paths(PathSelectors.ant("/hello/{name}/{age}")).build();
	}
	//PathSelectors
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Swagger without the use of annotations")
				.description("My First Swagger Description. Professional HB customer.")
				.termsOfServiceUrl("http://localhost:8080/swagger-ui.html").licenseUrl("hb@hb.com").version("1.0")
				.build();
	}

}