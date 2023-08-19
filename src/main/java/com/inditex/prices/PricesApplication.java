package com.inditex.prices;

import java.util.TimeZone;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class PricesApplication {

	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(PricesApplication.class, args);
	}
	
	 @PostConstruct
	 public void init(){
		 // Setting Spring Boot SetTimeZone
	     TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	 }

}
