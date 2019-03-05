package com.hrm.service;

import java.util.List;
import java.util.Map;

import com.hrm.domain.Dept;
import com.hrm.domain.Employee;
import com.hrm.domain.Job;
import com.hrm.domain.User;

public interface EmployeeService {
	//根据id查询员工
	public Employee selectById(int id);
	//获取动态查找
	public List<Employee> selectEmployee(Employee employee);
	//添加员工
	public void insertEmployee(Employee employee);
	//根据id删除员工
	public int deleteById(int id);
	//修改员工
	public void updateEmployee(Employee employee);
	public List<Employee> findEmployee(Employee employee);
	//将用户全部取出来放在map中
	public List<Employee> countEmployee(Map params);
	//记录
	public int countList();
}
