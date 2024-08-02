package org.ruoxue.spring_boot_168.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

//@EnableOpenApi
//@EnableKnife4j
//@Configuration
//@ConditionalOnProperty(name = "springfox.documentation.enabled", havingValue = "true")
public class Swagger3Config {
	
	public Swagger3Config() {
		
	}
	
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30).apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.ruoxue.spring_boot_168"))
                .paths(PathSelectors.any())
                .build().pathMapping("/");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SB 168")
                .description("SB 168")
                .contact(new Contact("若雪", "https://www.ruoxue.org", "ruoxueorg@gmail.com"))
                .version("0.0.1")
                .build();
    }
}