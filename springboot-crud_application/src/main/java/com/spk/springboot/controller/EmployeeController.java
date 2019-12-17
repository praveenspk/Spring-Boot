package com.spk.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spk.springboot.model.Employee;
import com.spk.springboot.service.EmployeeService;

/**
 * @author Praveen
 *
 */

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping("/list")
	public List<Employee> getEmps() {

		return service.getEmployee();
	}

	@PostMapping("/save")
	public Employee saveEmp(@RequestBody Employee emp) {
		service.saveEmp(emp);
		return emp;
	}

	@GetMapping("/employee/{id}")
	public Employee getEmpById(@PathVariable int id) {
		Employee emp = service.getEmpById(id);
		if (emp == null) {
			throw new RuntimeException("Employee with id" + id + " Not found");
		}
		return emp;
	}

	@DeleteMapping("/employee/{id}")
	public String deleteEmployee(@PathVariable int id) {
		service.deleteEmp(id);
		return "Employee has been deleted having id: " + id;

	}

	@PutMapping("/update")
	public Employee updateEmp(@RequestBody Employee emp) {

		service.saveEmp(emp);
		return emp;
	}
}
