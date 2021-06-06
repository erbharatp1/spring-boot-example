package com.bharat.it.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bharat.it.exception.RecordNotFoundException;
import com.bharat.it.model.Employee;
import com.bharat.it.service.EmployeeService;

/**
 * 
 * @author bharat.patel
 *
 */
@RestController
@RequestMapping("/employees")
public class EmployeeController {
	Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	EmployeeService service;

	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployees() {
		logger.info("EmployeeController.getAllEmployees()");
		List<Employee> list = service.getAllEmployees();

		return new ResponseEntity<List<Employee>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) throws RecordNotFoundException {

		logger.info("EmployeeController.getEmployeeById()");
		Employee entity = service.getEmployeeById(id);

		return new ResponseEntity<Employee>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<Employee> createOrUpdateEmployee(Employee employee) throws RecordNotFoundException {
		logger.info("EmployeeController.createOrUpdateEmployee()"+employee.toString());
		Employee updated = service.createOrUpdateEmployee(employee);
		return new ResponseEntity<Employee>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteEmployeeById(@PathVariable("id") Long id) throws RecordNotFoundException {
		logger.info("EmployeeController.deleteEmployeeById()");
		service.deleteEmployeeById(id);
		return HttpStatus.FORBIDDEN;
	}

}