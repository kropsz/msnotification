package com.compassuol.sp.challenge.msnotification.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SpringDocConfig {

        @Bean
        public OpenAPI openAPI() {
                return new OpenAPI()
                                .components(new Components())
                                .info(
                                                new Info()
                                                                .title("API de Notificação de Eventos")
                                                                .description("API para notificação de eventos de uma aplicação de e-commerce.")
                                                                .version("v1")
                                                                .license(new License().name("Apache 2.0").url(
                                                                                "https://www.apache.org/licenses/LICENSE-2.0"))
                                                                .contact(new Contact().name("Pedro Esteves")
                                                                                .email("pedroesteves007@outlook.com")));
        }

}