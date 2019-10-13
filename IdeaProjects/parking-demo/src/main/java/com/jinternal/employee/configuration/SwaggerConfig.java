package com.jinternal.employee.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static springfox.documentation.builders.RequestHandlerSelectors.any;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(any())
                .paths(PathSelectors.ant("/api/**"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Car Employee Lot REST API",
                "Car Employee Lot REST API for Demo.",
                "1.0",
                "Terms of service",
                new Contact("Kunal Vohra", "https://www.linkedin.com/in/vohra01/", "vohra.kunal3@gmail.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
}
