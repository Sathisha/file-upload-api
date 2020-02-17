package com.file.stream;

import com.file.stream.controller.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

@SpringBootApplication
public class StreamApplication {

	public static void main(String[] args) {

		SpringApplication.run(StreamApplication.class, args);
	}

}
