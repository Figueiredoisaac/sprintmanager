package com.figueiredoisaac.sprintmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = "figueiredoisaac.com.controllers")
public class SprintmanagerApplication {
	public static void main(String[] args) {
		SpringApplication.run(SprintmanagerApplication.class, args);
	}

}
