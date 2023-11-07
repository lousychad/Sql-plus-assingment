package com.mindgate.main.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mindgate.main.Repository.EmployeeRepositoryInterface;
import com.mindgate.main.domain.Employee;

@Repository
public class EmployeeService implements EmployeeServiceInterface {

	@Autowired
	private EmployeeRepositoryInterface employeeRepositoryInterface;

	public boolean addNewEmployee(Employee employee) {
		return employeeRepositoryInterface.addNewEmployee(employee);
	}

	public Employee updateEmployee(Employee empoyee) {
		return employeeRepositoryInterface.updateEmployee(empoyee);
	}

	public boolean deleteEmployee(int employeeId) {
		return employeeRepositoryInterface.deleteEmployee(employeeId);
	}

	public Employee getEmployeeByEmployeeId(int employeeId) {
		return employeeRepositoryInterface.getEmployeeByEmployeeId(employeeId);
	}

	public List<Employee> getAllEmployees() {
		return employeeRepositoryInterface.getAllEmployees();
	}

}
