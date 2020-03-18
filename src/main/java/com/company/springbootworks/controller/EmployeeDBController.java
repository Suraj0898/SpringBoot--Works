package com.company.springbootworks.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.springbootworks.beans.Employee;
import com.company.springbootworks.service.EmployeeDBService;


@RestController
public class EmployeeDBController {
	
	@Autowired
	private EmployeeDBService employeeService;
	
	@PostMapping("/emps-db")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.insertEmployee(employee);
	}
	
	@GetMapping("/emps-db")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@PutMapping("/emps-db")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}
	
	@DeleteMapping("/emps-db/{empid}")
	public void deleteEmployee(@PathVariable int empid) {
		employeeService.deleteEmployee(empid);
	}
	
	@GetMapping("emps-db/{empid}")
	public Optional<Employee> getEmployee(@PathVariable int empid){
		return employeeService.getEmployeeById(empid);
	}
	
	@GetMapping("/emps-db/age/{empid}")
	public List<Employee> getEmployeeGreaterThanAge(@PathVariable int empAge){
		return employeeService.getEmployeeByAge(empAge);
	}

}
