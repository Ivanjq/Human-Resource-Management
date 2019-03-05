package com.hrm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrm.dao.JobDao;
import com.hrm.domain.Job;
import com.hrm.service.JobService;

@Service("jobService")
public class JobServiceImpl implements JobService {
	@Autowired
	JobDao jobDao;

	//根据id删除职位
	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return jobDao.deleteById(id);
	}
	//插入职位
	@Override
	public void insertJob(Job job) {
		// TODO Auto-generated method stub
		jobDao.insertJob(job);
	}
	//根据id查询
	@Override
	public Job selectById(int id) {
		// TODO Auto-generated method stub
		return jobDao.selectById(id);
	}
	//查询所有职位
	@Override
	public List<Job> selectJob(Job job) {
		// TODO Auto-generated method stub
		return jobDao.selectJob(job);
	}
	//修改职位
	@Override
	public void updateJob(Job job) {
		// TODO Auto-generated method stub
		jobDao.updateJob(job);
	}
	@Transactional(readOnly=true)
	@Override
	public List<Job> selectAllJob() {
		// TODO Auto-generated method stub
		return jobDao.selectAllJob();
	}
	@Override
	public List<Job> countJob(Map params) {
		// TODO Auto-generated method stub
		return jobDao.countJob(params);
	}
	@Override
	public int countList() {
		// TODO Auto-generated method stub
		return jobDao.countList();
	}
	@Override
	public List<Job> findAllJob() {
		// TODO Auto-generated method stub
		return jobDao.selectAllJob();
	}


}
