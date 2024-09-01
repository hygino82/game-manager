package br.dev.hygino.manager.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/api/**").allowedOrigins("http://127.0.0.1:5500")//live server port
				.allowedMethods("GET", "POST", "PUT", "DELETE")
				.allowedHeaders("Origin", "Content-Type", "Accept");
	}
}