package com.emp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emp.bean.Employee;
import com.emp.dao.EmployeeDao;
@Service
@Transactional
public class EmployeeServiceImpl implements com.emp.service.EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public int save(Employee p) {

		return employeeDao.save(p);
	}

	@Override
	public List<Employee> getEmployees() {
		return employeeDao.getEmployees();
	}

	@Override
	public Employee getEmpById(int id) {
		return employeeDao.getEmpById(id);
	}

	@Override
	public int delete(int id) {

		return employeeDao.delete(id);
	}

	@Override
	public int update(Employee p) {
		return employeeDao.update(p);
	}

}
