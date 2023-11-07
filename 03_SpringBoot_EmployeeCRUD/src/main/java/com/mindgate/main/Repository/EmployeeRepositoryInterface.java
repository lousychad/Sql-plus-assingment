package com.mindgate.main.Repository;

import java.util.List;

import com.mindgate.main.domain.Employee;

public interface EmployeeRepositoryInterface {

	public boolean addNewEmployee(Employee employee);

	public Employee updateEmployee(Employee empoyee);

	public boolean deleteEmployee(int employeeId);

	public Employee getEmployeeByEmployeeId(int employeeId);

	public List<Employee> getAllEmployees();

}
