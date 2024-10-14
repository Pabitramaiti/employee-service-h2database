package com.pabi.empsvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pabi.empsvc.entity.Employee;
import com.pabi.empsvc.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	private int count = 1;

	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		return ResponseEntity.ok(employeeService.saveEmployee(employee));
	}

	@PutMapping("/updateEmployee")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		return ResponseEntity.ok(employeeService.updateEmployee(employee));
	}

	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable int id) {
		return ResponseEntity.ok(employeeService.deleteEmployee(id));
	}

	@GetMapping("/getEmployees")
	public ResponseEntity<List<Employee>> getEmployees() {
		System.out.println(">>>>> Inside getEmployees " + count++);
		return ResponseEntity.ok(employeeService.getEmployee());
	}
	
	@GetMapping("/getemployee/{id}")
	public ResponseEntity<Employee> getEmployeebyId(@PathVariable int id) {
		return ResponseEntity.ok(employeeService.getEmployeeById(id));
	}
	
	@GetMapping("/getemployeeconsume/{id}")
	public ResponseEntity<Employee> getEmployeebyIdConsumetion(@PathVariable int id) {
		return employeeService.consumeService(id);
	}
}
