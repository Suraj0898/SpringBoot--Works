package com.company.springbootworks.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.springbootworks.beans.Employee;
import com.company.springbootworks.repo.EmployeeRepository;

@Service
public class EmployeeDBService{
		
		@Autowired
		private EmployeeRepository employeeRepository;
		
		public  Optional<Employee> getEmployeeById(Integer empId) {
			return employeeRepository.findById(empId);
		}
		
		public List<Employee> getEmployeeByAge(Integer empAge) {
			return employeeRepository.findByAge(empAge);
		}
		
		public Employee insertEmployee(Employee employee) {
			return employeeRepository.insert(employee);
		}
		
		//Make sure to give ID
		public Employee updateEmployee(Employee employee) {
			return employeeRepository.save(employee);
		}
		
		public void deleteEmployee(Integer empId) {
			employeeRepository.deleteById(empId);
		}
		
		public List<Employee> getAllEmployees(){
			return employeeRepository.findAll();		
		}
		
		

}
