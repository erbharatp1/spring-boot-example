package com.bharat.it.service;

import java.util.List;

import com.bharat.it.exception.RecordNotFoundException;
import com.bharat.it.model.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployees();

	public Employee getEmployeeById(Long id) throws RecordNotFoundException;

	public Employee createOrUpdateEmployee(Employee entity) throws RecordNotFoundException;

	public void deleteEmployeeById(Long id) throws RecordNotFoundException ;
}
