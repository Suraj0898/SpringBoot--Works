package com.company.springbootworks.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Component;

import com.company.springbootworks.beans.Address;
import com.company.springbootworks.beans.Employee;

@Component
public class EmployeeService {
	private static List<Employee> employees=new ArrayList<Employee>();
	
	static {
		employees.add(new Employee(101,"Suraj",22,"suraj@ps.com",new Address("101","Greeenwd","Reston","USA")));
		employees.add(new Employee(123,"Nik",25,"Nik@ps.com",new Address("123","Jayanagar","Bangalore","India")));
		employees.add(new Employee(134,"Prerana",56,"prer@ps.com",new Address("132","J.P Nagar","Bangalore","India")));
		employees.add(new Employee(127,"Siv",29,"siv@ps.com",new Address("134","Sunnyvale","Cupertino","USA")));
	}
	
	public List<Employee> getAllEmployee(){
		return employees;
	}
	
	public Employee saveEmployee(Employee employee) {
		if(employee.getId()==0) {
			employee.setId(employees.size()+1);
		}
		employees.add(employee);
		return employee;
	}
	
	public Employee findOneEmployee(int empId) {
		for(Employee emp:employees) {
			if(emp.getId()==empId) {
				return emp;
			}
		}
		return null;
	}
	
	public Employee updateEmployee(Employee employee) {
		this.deleteEmployee(employee.getId());
		employees.add(employee);
		return employee;
	}
	
	public Employee deleteEmployee(int empId) {
		for(Employee emp:employees) {
			if(emp.getId()==empId) {
				employees.remove(emp);
				return emp;
			}
		}
		return null;
	}
	
	
	
	
}
