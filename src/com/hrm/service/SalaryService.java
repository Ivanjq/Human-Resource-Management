package com.hrm.service;

import java.util.List;
import java.util.Map;
import com.hrm.domain.Salary;

public interface SalaryService {
	//根据id查询
	public Salary selectById(int id);
	//获取动态查找
	public List<Salary> selectSalary(Salary salary);
	//添加公
	public void insertSalary(Salary salary);
	//根据id删除
	public int deleteById(int id);
	//修改
	public void updateSalary(Salary salary);
	//将全部取出来放在map中
	public List<Salary> countSalary(Map params);
	//记录
	public int countList();
}
