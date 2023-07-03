package com.dermanet.backend;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.cloudinary.Cloudinary;

@SpringBootApplication
public class BackendApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	public Cloudinary cloudinary() {
		Map<String, String> config = new HashMap<>();
		config.put("cloud_name", "dzn9agqso");
		config.put("api_key", "193768623949852");
		config.put("api_secret", "sesyo8e4CQvjc92rZinM2lgI_LA");
		return new Cloudinary(config);
	}
}
