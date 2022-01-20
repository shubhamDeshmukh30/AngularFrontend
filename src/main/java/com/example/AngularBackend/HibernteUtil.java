package com.example.AngularBackend;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class HibernteUtil implements EmployeeRepo {

	@PersistenceContext
	EntityManager manager;

//	Session session = manager.unwrap(Session.class);

	@Override
	public List<Employee> findAll() {
		return manager.createQuery("FROM Employee ", Employee.class).getResultList();
	}

	@Override
	@Transactional
	public Employee saveEmployee(Employee employee) {
		manager.persist(employee);
		return employee;
	}

	@Override
	public Employee getEmployee(Long id) {
		return manager.find(Employee.class, id);
	}

	@Override
	@Transactional
	public Employee updateEmployee(Employee employee2) {
		
		manager.persist(employee2);
		return employee2;
	}

	@Override
	@Transactional
	public void deleteEmployee(Employee employee) {
		manager.remove(employee);

	}

}
