package com.bharat.it.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bharat.it.exception.RecordNotFoundException;
import com.bharat.it.model.Employee;
import com.bharat.it.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository repository;

	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = null;
		try {
			employeeList = repository.findAll();

			System.out.println("Going to sleep for 5 Secs.. to simulate backend call.");
			Thread.sleep(1000 * 5);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return employeeList;
	}

	public Employee getEmployeeById(Long id) throws RecordNotFoundException {
		Optional<Employee> employee = repository.findById(id);

		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

	@Transactional
	public Employee createOrUpdateEmployee(Employee entity) throws RecordNotFoundException {
//		Optional<Employee> employee = repository.findById(entity.getEmpId());
//
//		if (employee.isPresent()) {
//			Employee newEntity = employee.get();
//			newEntity.setEmail(entity.getEmail());
//			newEntity.setFirstName(entity.getFirstName());
//			newEntity.setLastName(entity.getLastName());
//
//			newEntity = repository.save(newEntity);
//
//			return newEntity;
//		} else {
		entity = repository.save(entity);

		return entity;
	}

	@Transactional
	public void deleteEmployeeById(Long id) throws RecordNotFoundException {
		Optional<Employee> employee = repository.findById(id);

		if (employee.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}
}