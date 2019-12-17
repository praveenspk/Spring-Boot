package com.spk.springboot.dao;

import java.util.List;

import com.spk.springboot.model.Employee;

/**
 * @author Praveen
 *
 */

public interface EmployeeDAO {

	List<Employee> getEmployee();

	Employee getEmpById(int id);

	void saveEmp(Employee emp);

	void deleteEmp(int id);

}
