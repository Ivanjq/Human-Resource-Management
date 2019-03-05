package com.hrm.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrm.dao.SalaryDao;
import com.hrm.domain.Salary;
import com.hrm.service.SalaryService;

@Service("salaryService")
public class SalaryServiceImpl implements SalaryService {
	@Autowired
	SalaryDao salaryDao;

	@Override
	public int countList() {
		// TODO Auto-generated method stub
		return salaryDao.countList();
	}

	@Override
	public List<Salary> countSalary(Map params) {
		// TODO Auto-generated method stub
		return salaryDao.countSalary(params);
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return salaryDao.deleteById(id);
	}

	@Override
	public void insertSalary(Salary salary) {
		// TODO Auto-generated method stub
		salaryDao.insertSalary(salary);
	}

	@Override
	public Salary selectById(int id) {
		// TODO Auto-generated method stub
		return salaryDao.selectById(id);
	}

	@Override
	public List<Salary> selectSalary(Salary salary) {
		// TODO Auto-generated method stub
		return salaryDao.selectSalary(salary);
	}

	@Override
	public void updateSalary(Salary salary) {
		// TODO Auto-generated method stub
		salaryDao.updateSalary(salary);
	}

}
