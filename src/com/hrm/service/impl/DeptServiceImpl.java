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
	
	//����idɾ���û�
	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return deptDao.deleteById(id);
	}
	//���벿��
	@Override
	public void insertDept(Dept dept) {
		// TODO Auto-generated method stub
		deptDao.insertDept(dept);
	}
	//����id��ѯ
	@Override
	public Dept selectById(int id) {
		// TODO Auto-generated method stub
		return deptDao.selectById(id);
	}
	//��ѯ����
	@Override
	public List<Dept> selectDept(Dept dept) {
		// TODO Auto-generated method stub
		return deptDao.selectDept(dept);
	}
	//�޸Ĳ���
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
