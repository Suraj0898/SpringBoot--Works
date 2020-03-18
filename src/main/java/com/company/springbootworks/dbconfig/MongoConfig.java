package com.company.springbootworks.dbconfig;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.company.springbootworks.beans.Address;
import com.company.springbootworks.beans.Employee;
import com.company.springbootworks.repo.EmployeeRepository;

@Configuration
@EnableMongoRepositories(basePackageClasses = EmployeeRepository.class)
public class MongoConfig {
	
	@Bean
	public CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository) {
		return string -> {
			
			new Employee(12345,"Mayank",24,"mayank@ps.com",new Address("109","Innsbruck","Austria","Europe"));
		};
	}

}
