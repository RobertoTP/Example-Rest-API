package com.example.demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * PAGINA PRINCIPAL DE SWAGGER
 * /swagger-ui.html
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .securitySchemes(
                        Collections.singletonList(
                                new ApiKey(HttpHeaders.AUTHORIZATION, HttpHeaders.AUTHORIZATION, ApiKeyVehicle.HEADER.getValue())
                        )
                )
                .securityContexts(
                        Collections.singletonList(
                                SecurityContext.builder().securityReferences(
                                        Collections.singletonList(
                                                new SecurityReference(HttpHeaders.AUTHORIZATION, new AuthorizationScope[0])
                                        )
                                ).build()
                        )
                )
                .apiInfo(SwaggerConfig.buildApiInfo())
                .select()
                // Paquete de la documentacion
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.Controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private static ApiInfo buildApiInfo() {
        return new ApiInfoBuilder()
                .title("API")
                .description("REST API")
                .version("1.0")
                .contact(
                        new Contact(
                                "Roberto Torres Pintos",
                                "https://github.com/RobertoTP",
                                "roberto.torres.pintos@rai.usc.es"
                        )
                )
                .build();
    }
}
