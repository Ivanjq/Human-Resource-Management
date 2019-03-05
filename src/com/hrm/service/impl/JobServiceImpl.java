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

	//����idɾ��ְλ
	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return jobDao.deleteById(id);
	}
	//����ְλ
	@Override
	public void insertJob(Job job) {
		// TODO Auto-generated method stub
		jobDao.insertJob(job);
	}
	//����id��ѯ
	@Override
	public Job selectById(int id) {
		// TODO Auto-generated method stub
		return jobDao.selectById(id);
	}
	//��ѯ����ְλ
	@Override
	public List<Job> selectJob(Job job) {
		// TODO Auto-generated method stub
		return jobDao.selectJob(job);
	}
	//�޸�ְλ
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
