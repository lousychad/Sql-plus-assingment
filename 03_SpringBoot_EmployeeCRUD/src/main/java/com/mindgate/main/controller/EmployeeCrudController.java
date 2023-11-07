package com.mindgate.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.main.Service.EmployeeServiceInterface;
import com.mindgate.main.domain.Employee;

@RestController
@RequestMapping("employeeapi")
@CrossOrigin("*")
public class EmployeeCrudController {
	@Autowired
	private EmployeeServiceInterface employeeServiceInterface;
	
	//http://localhost:8081/employeeapi/employees/7

	@RequestMapping(value = "employees/{employeeId}", method = RequestMethod.GET)
	public Employee getEmployee(@PathVariable int employeeId) {
		return employeeServiceInterface.getEmployeeByEmployeeId(employeeId);
	}
	
	//http://localhost:8081/employeeapi/employees/7

	@RequestMapping(value = "employees/{employeeId}", method = RequestMethod.DELETE)
	public boolean deleteEmployee(@PathVariable int employeeId) {
		return employeeServiceInterface.deleteEmployee(employeeId);
	}
	
	//http://localhost:8081/employeeapi/employees/employee

	@RequestMapping(value = "employees/employee", method = RequestMethod.POST)
	public boolean addEmployee(@RequestBody Employee employee) {
		return employeeServiceInterface.addNewEmployee(employee);
	}
	
	//http://localhost:8081/employeeapi/employees/employee

	@RequestMapping(value = "employees/employee", method = RequestMethod.PUT)
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeServiceInterface.updateEmployee(employee);
	}

	// http://localhost:8081/employeeapi/employees

	@RequestMapping(value = "employees", method = RequestMethod.GET)
	public List<Employee> getAllEmployees() {
		return employeeServiceInterface.getAllEmployees();

	}

}
