package com.hrm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hrm.dao.DeptDao;
import com.hrm.domain.Dept;
import com.hrm.service.DeptService;

@Service("deptService")
public class DeptServiceImpl implements DeptService {
	@Autowired
	DeptDao deptDao;
	
	//根据id删除用户
	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return deptDao.deleteById(id);
	}
	//插入部门
	@Override
	public void insertDept(Dept dept) {
		// TODO Auto-generated method stub
		deptDao.insertDept(dept);
	}
	//根据id查询
	@Override
	public Dept selectById(int id) {
		// TODO Auto-generated method stub
		return deptDao.selectById(id);
	}
	//查询部门
	@Override
	public List<Dept> selectDept(Dept dept) {
		// TODO Auto-generated method stub
		return deptDao.selectDept(dept);
	}
	//修改部门
	@Override
	public void updateDept(Dept dept) {
		// TODO Auto-generated method stub
		deptDao.updateDept(dept);
	}
	@Override
	public List<Dept> countDept(Map params) {
		// TODO Auto-generated method stub
		return deptDao.countDept(params);
	}
	@Override
	public int countList() {
		// TODO Auto-generated method stub
		return deptDao.countList();
	}
	@Override
	public List<Dept> findAllDept() {
		// TODO Auto-generated method stub
		return deptDao.selectAllDept();
	}

}
