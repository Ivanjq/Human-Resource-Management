package com.hrm.service;

import java.util.List;
import java.util.Map;

import com.hrm.domain.Dept;
import com.hrm.domain.User;

public interface DeptService {
	//根据id查询部门
	public Dept selectById(int id);
	//获取动态查找
	public List<Dept> selectDept(Dept dept);
	//添加部门
	public void insertDept(Dept dept);
	//根据id删除部门
	public int deleteById(int id);
	//修改部门
	public void updateDept(Dept dept);
	//将用户全部取出来放在map中
	public List<Dept> countDept(Map params);
	//记录
	public int countList();
	//查询全部的部门
	public List<Dept> findAllDept();
}
