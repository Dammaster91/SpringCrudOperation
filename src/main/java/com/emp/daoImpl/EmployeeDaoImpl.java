package com.emp.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.emp.bean.Employee;
import com.emp.dao.EmployeeDao;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	private JdbcTemplate template;

//	public void setTemplate(JdbcTemplate template) {
//		this.template = template;
//	}

	@Override
	public int save(Employee p) {
		String sql = "insert into Employee(id,name,salary,designation) values(" + p.getId() + ",'" + p.getName() + "',"
				+ p.getSalary() + ",'" + p.getDesignation() + "')";
		return template.update(sql);
	}

	@Override
	public int update(Employee p) {
		String sql = "update Employee set name='" + p.getName() + "', salary=" + p.getSalary() + ",designation='"
				+ p.getDesignation() + "' where id=" + p.getId() + "";
		return template.update(sql);
	}

	@Override
	public int delete(int id) {
		String sql = "delete from Employee where id=" + id + "";
		return template.update(sql);
	}

	@Override
	public Employee getEmpById(int id) {
		String sql = "select * from Employee where id=?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<Employee>(Employee.class));
	}

	@Override
	public List<Employee> getEmployees() {
		return template.query("select id, name,salary,designation from Employee", new RowMapper<Employee>() {
			public Employee mapRow(ResultSet rs, int row) throws SQLException {
				Employee e = new Employee();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getFloat(3));
				e.setDesignation(rs.getString(4));
				return e;
			}
		});
	}

}