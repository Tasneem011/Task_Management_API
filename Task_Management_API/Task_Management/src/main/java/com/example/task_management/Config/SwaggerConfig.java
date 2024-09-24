package com.example.task_management.Config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI().info(new Info().title("Task Management API"))
                .addSecurityItem(new SecurityRequirement().addList("Task Management Scheme"))
                .components(new Components().addSecuritySchemes("Task Management Scheme", new SecurityScheme()
                        .name("Task Management Scheme").type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("Jwt")));
    }
}