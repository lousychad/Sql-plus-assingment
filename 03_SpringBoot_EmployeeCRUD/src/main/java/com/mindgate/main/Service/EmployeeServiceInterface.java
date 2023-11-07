package com.mindgate.main.Service;

import java.util.List;

import com.mindgate.main.domain.Employee;

public interface EmployeeServiceInterface {
	public boolean addNewEmployee(Employee employee);

	public Employee updateEmployee(Employee empoyee);

	public boolean deleteEmployee(int employeeId);

	public Employee getEmployeeByEmployeeId(int employeeId);

	public List<Employee> getAllEmployees();


}
