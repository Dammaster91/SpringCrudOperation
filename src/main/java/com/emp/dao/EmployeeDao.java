package com.emp.dao;

import java.util.List;

import com.emp.bean.Employee;

public interface EmployeeDao {

	public int save(Employee p);

	public List<Employee> getEmployees();

	public Employee getEmpById(int id);

	public int delete(int id);

	public int update(Employee p);

}
