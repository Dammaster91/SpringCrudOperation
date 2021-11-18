package com.emp.service;

import java.util.List;

import com.emp.bean.Employee;

public interface EmployeeService {

	public int save(Employee p);

	public List<Employee> getEmployees();

	public Employee getEmpById(int id);

	public int delete(int id);

	public int update(Employee p);

}
