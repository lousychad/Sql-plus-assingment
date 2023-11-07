package com.mindgate.main.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mindgate.main.domain.Employee;

@Repository
public class EmployeeRepository implements EmployeeRepositoryInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private final static String INSERT_NEW_EMPLOYEE = "insert into employee_details values(employee_id_sequence.nextVal,?,?)";
	private final static String UPDATE_EXISTING_EMPLOYEE = "update employee_details set name =?, salary =? where employee_id = ?";
	private final static String DELETE_EXISTING_EMPLOYEE = "delete from employee_details where employee_id = ?";
	private final static String SELECT_ALL_EMPLOYEES = "select * from employee_details";
	private final static String SELECT_ONE_EMPLOYEE = "select * from employee_details where employee_id = ?";

	public boolean addNewEmployee(Employee employee) {
		Object[] parameters = { employee.getName(), employee.getSalary(), };

		jdbcTemplate.update(INSERT_NEW_EMPLOYEE, parameters);
		return true;

	}

	public Employee updateEmployee(Employee employee) {
		Object[] parameters = { employee.getName(), employee.getSalary(), employee.getEmployeeId() };
		int rowCount = jdbcTemplate.update(UPDATE_EXISTING_EMPLOYEE, parameters);
		if (rowCount > 0) {
			return getEmployeeByEmployeeId(employee.getEmployeeId());
		}
		return null;
	}

	public boolean deleteEmployee(int employeeId) {

		int rowCount = jdbcTemplate.update(DELETE_EXISTING_EMPLOYEE, employeeId);
		if (rowCount > 0) {

			return true;
		} else {
			return false;
		}
	}

	public Employee getEmployeeByEmployeeId(int employeeId) {
		EmployeeRowMapper employeeRowMapper = new EmployeeRowMapper();
		return jdbcTemplate.queryForObject(SELECT_ONE_EMPLOYEE, employeeRowMapper, employeeId);

	}

	public List<Employee> getAllEmployees() {
		EmployeeRowMapper employeeRowMapper = new EmployeeRowMapper();
		return jdbcTemplate.query(SELECT_ALL_EMPLOYEES, employeeRowMapper);
	}
}
