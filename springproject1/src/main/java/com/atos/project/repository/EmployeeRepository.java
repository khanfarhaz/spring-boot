package com.atos.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atos.project.domain.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	
	 
	}


