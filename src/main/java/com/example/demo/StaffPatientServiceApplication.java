package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient
public class StaffPatientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StaffPatientServiceApplication.class, args);
	}

}
