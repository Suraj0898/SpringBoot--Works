package com.company.springbootworks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringBootWorksApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWorksApplication.class, args);
	}

}
