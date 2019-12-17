/**
 * 
 */
package com.spk.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spk.springboot.dao.EmployeeDAO;
import com.spk.springboot.model.Employee;

/**
 * @author Praveen
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO dao;

	@Transactional
	@Override
	public List<Employee> getEmployee() {
		// TODO Auto-generated method stub
		return dao.getEmployee();
	}

	@Transactional
	@Override
	public Employee getEmpById(int id) {
		return dao.getEmpById(id);

	}

	@Transactional
	@Override
	public void saveEmp(Employee emp) {
		dao.saveEmp(emp);

	}

	@Transactional
	@Override
	public void deleteEmp(int id) {
		dao.deleteEmp(id);

	}

}
