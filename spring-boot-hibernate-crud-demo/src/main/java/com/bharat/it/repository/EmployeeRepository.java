package com.bharat.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bharat.it.model.Employee;
/**
 * 
 * @author bharat.patel
 *
 */
@Repository
public interface EmployeeRepository
        extends JpaRepository<Employee, Long> {
 
}
