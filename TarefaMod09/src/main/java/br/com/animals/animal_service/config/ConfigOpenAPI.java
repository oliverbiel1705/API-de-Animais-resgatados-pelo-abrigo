package br.com.animals.animal_service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigOpenAPI {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Animals API")
                        .version("v1")
                        .description("Animals API")
                        .termsOfService("Termos de serviço")
                        .license(new License().name("MIT License").url(" https://opensource.org/licenses/MIT"))
                        .contact(new Contact().name("maxjdev").email("maxjramosdev@gmail.com").url("https://www.linkedin.com/in/maxjdev/"))
                );
    }
}
