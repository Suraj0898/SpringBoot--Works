package com.company.springbootworks.controller;

import java.util.List;

import org.omg.CORBA.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.company.springbootworks.beans.Employee;
import com.company.springbootworks.service.EmployeeService;


@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private org.springframework.core.env.Environment environment;
	
	@CrossOrigin
	@GetMapping("/emps")
	public List<Employee> getAllEmployee(){
		return employeeService.getAllEmployee();
	}
	
	@GetMapping("/emps/{empId}")
	public HttpEntity<Employee> getEmployee(@PathVariable int empId) {
		Employee employee=employeeService.findOneEmployee(empId);
		
		//If the user is null then
		//Throw new UserNotFoundException("Sorry no user found")
		
	//	Employee emp=employee.add(linkTo(methodOn(EmployeeController.class).getAllEmployee()).withSelfRel());
		employee.setPort(Integer.parseInt(environment.getProperty("local.server.port"))); 
		
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
		
		
		 
	}
	
	@PostMapping("/emps")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		
		System.out.println(employee);
		Employee emp=employeeService.saveEmployee(employee);
		return new ResponseEntity<Employee>(emp,HttpStatus.CREATED);
		//return employeeService.saveEmployee(employee);
	}
	
	
	@PutMapping("/emps")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}
	
	@DeleteMapping("/emps/{empid}")
	public Employee saveEmployee(@PathVariable int empid) {
		return employeeService.deleteEmployee(empid);
	}
	
	
}
