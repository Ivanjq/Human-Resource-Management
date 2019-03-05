package com.hrm.service;

import java.util.List;
import java.util.Map;
import com.hrm.domain.Salary;

public interface SalaryService {
	//����id��ѯ
	public Salary selectById(int id);
	//��ȡ��̬����
	public List<Salary> selectSalary(Salary salary);
	//��ӹ�
	public void insertSalary(Salary salary);
	//����idɾ��
	public int deleteById(int id);
	//�޸�
	public void updateSalary(Salary salary);
	//��ȫ��ȡ��������map��
	public List<Salary> countSalary(Map params);
	//��¼
	public int countList();
}
