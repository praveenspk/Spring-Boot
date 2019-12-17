/**
 * 
 */
package com.spk.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spk.springboot.model.Employee;

/**
 * @author Praveen
 *
 */

@Repository
public class EmpDAOImpl implements EmployeeDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Employee> getEmployee() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
		List<Employee> list = query.getResultList();
		return list;
	}

	@Override
	public Employee getEmpById(int id) {

		Session currentSession = entityManager.unwrap(Session.class);
		Employee emp = currentSession.get(Employee.class, id);
		return emp;
	}

	@Override
	public void saveEmp(Employee emp) {

		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(emp);

	}

	@Override
	public void deleteEmp(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Employee emp = currentSession.get(Employee.class, id);
		currentSession.delete(emp);

	}

}
