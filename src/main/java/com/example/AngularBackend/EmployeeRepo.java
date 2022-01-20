package com.example.AngularBackend;

import java.util.List;


public interface EmployeeRepo {

	public List<Employee> findAll();

	public Employee saveEmployee(Employee employee);

	public Employee getEmployee(Long id);

	public Employee updateEmployee(Employee employee2);

	public void deleteEmployee(Employee employee);
	
}
