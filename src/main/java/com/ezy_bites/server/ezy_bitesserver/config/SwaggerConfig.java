package com.ezy_bites.server.ezy_bitesserver.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private Environment environment;

    @Bean
    public OpenAPI customOpenAPI() {
        // Get context path (e.g., "/" or "/ezybites")
        String contextPath = servletContext.getContextPath();
        if (contextPath.isEmpty()) {
            contextPath = "/";
        }

        // Get server port (default to 8080 if not specified)
        String port = environment.getProperty("server.port", "8080");

        // Get server scheme (http or https, default to http)
        String scheme = environment.getProperty("server.ssl.enabled", Boolean.class, false) ? "https" : "http";

        // Get server host (default to localhost)
        String host = environment.getProperty("server.address", "localhost");

        // Construct base URL
        String serverUrl = String.format("%s://%s:%s%s", scheme, host, port, contextPath);

        return new OpenAPI()
                .info(new Info()
                        .title("Ezy Bites API")
                        .version("1.0")
                        .description("API documentation for Ezy Bites Server"))
                .servers(List.of(new Server()
                        .url(serverUrl)
                        .description("Dynamic Server URL")));
    }
}