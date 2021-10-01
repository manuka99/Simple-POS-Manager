package com.simplepos.employee_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class SimplePosEmployeeManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimplePosEmployeeManagementApplication.class, args);
	}

}
