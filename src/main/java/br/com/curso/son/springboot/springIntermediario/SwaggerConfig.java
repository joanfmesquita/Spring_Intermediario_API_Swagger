package br.com.curso.son.springboot.springIntermediario;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket apiConfigDocs() {
		
		return new Docket (DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.curso.son.springboot.springIntermediario.resources"))
				.paths( PathSelectors.any()).build();
	}
	
	private ApiInfo infDocs() {
		return new ApiInfo("Spring Intermediario API", "API Spring", "1.0", "Terms", new Contact("Joan", "localhost:8080/api/product", "joanmesquita@gmail.com"), "URL", null, new ArrayList<VendorExtension>());
	}
	
}
