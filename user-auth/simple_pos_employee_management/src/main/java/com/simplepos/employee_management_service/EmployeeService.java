package com.simplepos.employee_management_service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.simplepos.employee_management_models.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();
	void saveEmployee(Employee employee);
	Employee getEmployeeById(long id);
void deleteEmployeeById(long id);
Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection );
}
