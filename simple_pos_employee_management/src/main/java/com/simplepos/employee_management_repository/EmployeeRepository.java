package com.simplepos.employee_management_repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplepos.employee_management_models.Employee;

@Repository

public interface EmployeeRepository extends JpaRepository <Employee, Long> {
	
	

}
