package com.portafolio.crudproductos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity  // Habilita la seguridad web
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        // Crea usuarios en memoria (solo para desarrollo)
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user")
                .password("{noop}password")  // {noop} indica que la contraseña no está encriptada (solo pruebas)
                .roles("USER")
                .build());
        manager.createUser(User.withUsername("admin")
                .password("{noop}admin123")
                .roles("ADMIN")
                .build());
        return manager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/","/login", "/css/**", "/js/**", "/images/**").permitAll()                        .requestMatchers("/productos/editar/**", "/productos/eliminar/**").hasRole("ADMIN")  // Solo ADMIN
                        .anyRequest().authenticated()  // El resto requiere autenticación
                )
                .formLogin(form -> form
                        .loginPage("/login")  // Página de login personalizada
                        .defaultSuccessUrl("/productos", true)  // Redirige aquí tras login exitoso
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/")  // Redirige a la raíz tras logout
                        .permitAll()
                );
        return http.build();
    }
}