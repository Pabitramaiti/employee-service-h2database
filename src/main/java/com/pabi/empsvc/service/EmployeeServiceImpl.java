package com.pabi.empsvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pabi.empsvc.entity.Employee;
import com.pabi.empsvc.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
    EmployeeRepository repository;

	@Override
    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }
	
	@Override
    public List<Employee> saveEmployee(List<Employee> employee) {
        return repository.saveAll(employee);
    }
	
	@Override
    public List<Employee> getEmployee() {
        return repository.findAll();
    }

	@Override
    public Employee getEmployeeById(int id) {
		//return repository.getEmployeeById(id);
        return repository.findById(id).orElse(null);
    }

	@Override
    public Employee getEmployeeByName(String name) {
    	Employee emp = null;
        if (repository.findByFirstName(name) !=null ) {
        	emp = repository.findByFirstName(name);
        }else {
        	emp = repository.findByLastName(name);
        }
        return emp;
    }

    @Override
    public Employee deleteEmployee(int id) {
        repository.deleteById(id);
        //return "Employee removed !! " + id;
        return repository.findById(id).orElse(null);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Employee existingEmployee = repository.findById(employee.getId()).orElse(null);
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setAge(employee.getAge());
        existingEmployee.setSalary(employee.getSalary());
        return repository.save(existingEmployee);
    }
    
    
    @Override
	public ResponseEntity<Employee> consumeService(int id) {
		
		String url = "http://localhost:8080/employee/getemployee/"+id;
		RestTemplate restTemplate =new RestTemplate();
		return restTemplate.getForEntity(url, Employee.class);
	}
}
