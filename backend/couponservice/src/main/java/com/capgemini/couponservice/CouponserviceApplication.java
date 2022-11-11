package com.capgemini.couponservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import org.springframework.context.annotation.Bean;



import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@EnableSwagger2
@SpringBootApplication
@EnableEurekaClient

public class CouponserviceApplication {

	
	/*
    author : Annesha Debnath
	   creation date : 01.09.2022
	   modification date : 01.09.2022
	   description : This method acts as main method from where the execution of the microservice begins.
	*/
	public static void main(String[] args) {
		
		SpringApplication.run(CouponserviceApplication.class, args);
	}
	
	/*
    author : Annesha Debnath
	   creation date : 02.09.2022
	   modification date : 02.09.2022
	   description : This method creates a docket which a builder which is 
	                 intended to be the primary interface into the swagger
	   url for swagger : http://localhost:8081/swagger-ui.html
	*/
	@Bean
	   public Docket couponApi() {
	      return new Docket(DocumentationType.SWAGGER_2).select()
	    		  .apis(RequestHandlerSelectors.basePackage("com.capgemini.couponservice")).build();  
	   }
	
	

}

