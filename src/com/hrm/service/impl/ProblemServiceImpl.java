package com.hrm.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hrm.dao.ProblemDao;
import com.hrm.domain.Problem;
import com.hrm.service.ProblemService;

@Service("problemService")
public class ProblemServiceImpl implements ProblemService {
	@Autowired
	ProblemDao problemDao;

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return problemDao.deleteById(id);
	}

	@Override
	public void insertProblem(Problem problem) {
		// TODO Auto-generated method stub
		problemDao.insertProblem(problem);
	}

	@Override
	public Problem selectById(int id) {
		// TODO Auto-generated method stub
		return problemDao.selectById(id);
	}

	@Override
	public List<Problem> selectProblem(Problem problem) {
		// TODO Auto-generated method stub
		return problemDao.selectProblem(problem);
	}

	@Override
	public void updateProblem(Problem problem) {
		// TODO Auto-generated method stub
		problemDao.updateProblem(problem);
	}

	@Override
	public int countList() {
		// TODO Auto-generated method stub
		return problemDao.countList();
	}

	@Override
	public List<Problem> countProblem(Map params) {
		// TODO Auto-generated method stub
		return problemDao.countProblem(params);
	}
	
}
