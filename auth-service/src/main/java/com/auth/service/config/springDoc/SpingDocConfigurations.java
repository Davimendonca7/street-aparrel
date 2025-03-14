package com.auth.service.config.springDoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpingDocConfigurations {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer")
                                        .bearerFormat("JWT"))).info(new Info().title("Street Aparrel API")
                        .description("API Rest da aplicação Street Aparrel, contendo as funcionalidades de CRUD de " +
                                "clientes e produtos, além do gerenciamento de pedidos")
                        .contact(new Contact()
                                .name("Time Backend")
                                .email("admin@streetAparrel.com")));
    }
}
