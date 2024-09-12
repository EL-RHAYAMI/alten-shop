package com.alten.shop.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "ALTEN",
                        email = "contact@alten.com",
                        url = "https://www.alten.com/"
                ),
                description = "OpenApi documentation for Alten Shop",
                title = "Alten Shop API-doc",
                version = "1.0.0"
        ),
        servers = {
                @Server(
                        description = "Local Env",
                        url = "http://localhost:8090"
                )
        }
)
public class OpenApiConfig {
}