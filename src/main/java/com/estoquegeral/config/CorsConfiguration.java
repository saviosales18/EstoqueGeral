package com.estoquegeral.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
         return new WebMvcConfigurer() {
             @Override
             public void addCorsMappings(@org.springframework.lang.NonNull CorsRegistry corsRegistry) {
                 corsRegistry.addMapping("/**")
                         .allowedOrigins("http://localhost:5500")
                 .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                 .allowCredentials(true);
             }
         };
    }
}
