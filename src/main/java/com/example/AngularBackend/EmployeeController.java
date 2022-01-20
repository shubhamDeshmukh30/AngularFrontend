package com.example.AngularBackend;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

	@Autowired
	private EmployeeRepo employeeRepo;

	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return employeeRepo.findAll();
	}

	@PostMapping("/save/employee")
	public Employee createEmployee(@RequestBody Employee employee) {

		return employeeRepo.saveEmployee(employee);
	}

	@GetMapping("/get/employee/{id}")
	public Employee getEmployeeById(@PathVariable Long id) {

		return employeeRepo.getEmployee(id);
	}

	@PutMapping("/update/employee/{id}")
	public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		Employee employee2 = employeeRepo.getEmployee(id);

		employee2.setFirstName(employee.getFirstName());
		employee2.setLastName(employee.getLastName());
		employee2.setEmailId(employee.getEmailId());
		employee2.setState(employee.getState());
		employee2.setCity(employee.getCity());
		employee2.setPincode(employee.getPincode());

		return employeeRepo.updateEmployee(employee2);
	}

	@DeleteMapping("/delete/employee/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable Long id) {
		Employee employee = employeeRepo.getEmployee(id);
		employeeRepo.deleteEmployee(employee);
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("deleted", Boolean.TRUE);
		return map;
	}
}
