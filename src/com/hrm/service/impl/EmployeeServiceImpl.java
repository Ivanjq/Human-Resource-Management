package com.hrm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrm.dao.EmployeeDao;
import com.hrm.domain.Dept;
import com.hrm.domain.Employee;
import com.hrm.domain.Job;
import com.hrm.service.EmployeeService;
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDao employeeDao;
	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return employeeDao.deleteById(id);
	}

	@Override
	public void insertEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.insertEmployee(employee);
	}

	@Override
	public Employee selectById(int id) {
		// TODO Auto-generated method stub
		return employeeDao.selectById(id);
	}

	@Override
	public List<Employee> selectEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.selectEmployee(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.updateEmployee(employee);
	}

	@Override
	public List<Employee> findEmployee(Employee employee) {
		// TODO Auto-generated method stub
		List<Employee> employees=employeeDao.selectEmployee(employee);
		return employees;
	}

	@Override
	public List<Employee> countEmployee(Map params) {
		// TODO Auto-generated method stub
		return employeeDao.countEmployee(params);
	}

	@Override
	public int countList() {
		// TODO Auto-generated method stub
		return employeeDao.countList();
	}

}
