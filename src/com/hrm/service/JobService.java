package com.hrm.service;

import java.util.List;
import java.util.Map;

import com.hrm.domain.Dept;
import com.hrm.domain.Job;
import com.hrm.domain.User;

public interface JobService {
	//根据id查询职位
	public Job selectById(int id);
	//获取所有的职位
	List<Job> selectAllJob();
	//获取动态查找
	public List<Job> selectJob(Job job);
	//添加职位
	public void insertJob(Job job);
	//根据id删除职位
	public int deleteById(int id);
	//修改职位
	public void updateJob(Job job);
	//将用户全部取出来放在map中
	public List<Job> countJob(Map params);
	//记录
	public int countList();
	//查询全部的职位
	public List<Job> findAllJob();
}
