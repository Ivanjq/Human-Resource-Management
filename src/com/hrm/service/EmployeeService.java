package com.hrm.service;

import java.util.List;
import java.util.Map;

import com.hrm.domain.Dept;
import com.hrm.domain.Employee;
import com.hrm.domain.Job;
import com.hrm.domain.User;

public interface EmployeeService {
	//����id��ѯԱ��
	public Employee selectById(int id);
	//��ȡ��̬����
	public List<Employee> selectEmployee(Employee employee);
	//���Ա��
	public void insertEmployee(Employee employee);
	//����idɾ��Ա��
	public int deleteById(int id);
	//�޸�Ա��
	public void updateEmployee(Employee employee);
	public List<Employee> findEmployee(Employee employee);
	//���û�ȫ��ȡ��������map��
	public List<Employee> countEmployee(Map params);
	//��¼
	public int countList();
}
