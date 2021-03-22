package com.mehul.controller;

import java.util.List;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mehul.model.Employee;
import com.mehul.repository.EmployeeRepository;

@RestController("/emp-mgt")
//@RequestMapping("/emp-mgt")
public class EmployeeController {
	
	private static final Logger LOGGER = Logger.getLogger(EmployeeController.class);

	@Autowired 
	private EmployeeRepository employeeRepository;
	
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		LOGGER.debug("Saving Employee started...");
		@Valid
		Employee savedEmployee = employeeRepository.save(employee);
		LOGGER.debug("Saving Employee completed...");
		return savedEmployee;
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployees(){
		List<Employee> employees = employeeRepository.findAll();
		ResponseEntity<List<Employee>> response = new ResponseEntity<>(employees, HttpStatus.OK);
		return response;
	} 
}
