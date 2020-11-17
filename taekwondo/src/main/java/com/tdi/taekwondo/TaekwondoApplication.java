package com.tdi.taekwondo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TaekwondoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaekwondoApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		System.out.print("third statement");  
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				System.out.print("third statement");  
				registry.addMapping("/**")
				.allowedOrigins("http://localhost:4200")
				.allowedMethods("POST", "PUT", "GET", "PATCH", "DELETE");
			}
		};
	}
}
