package com.portafolio.crudproductos.config;

// Indica que esta clase es una clase de configuración de Spring
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



// Importa la clase necesaria para usar expresiones de seguridad en Thymeleaf (como sec:authorize)
import org.thymeleaf.extras.springsecurity6.dialect.SpringSecurityDialect;

@Configuration // Marca esta clase como una fuente de beans de configuración para el contexto de Spring
public class ThymeleafConfig {

    // Define un bean que registra el dialecto de seguridad de Spring para Thymeleaf
    @Bean
    public SpringSecurityDialect springSecurityDialect() {
        // Este dialecto permite que Thymeleaf entienda y procese etiquetas como <sec:authorize>
        return new SpringSecurityDialect();
    }
}