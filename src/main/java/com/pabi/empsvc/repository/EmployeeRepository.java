package com.pabi.empsvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pabi.empsvc.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //Optional<Employee> saveEmployee(Employee employee);
	public Employee findByFirstName(String fname);
	public Employee findByLastName(String lname);
	public Employee getEmployeeById(int id);
}
