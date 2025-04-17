package com.ezy_bites.server.ezy_bitesserver.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Ezy Bites API")
                        .version("1.0")
                        .description("API documentation for Ezy Bites Server"))
                .servers(List.of(
                        new Server().url("http://localhost:8080").description("Dev Server"),
                        new Server().url("https://determined-empathy-production.up.railway.app/").description("Prod Server")
                ));
    }


}