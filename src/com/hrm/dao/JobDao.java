package com.hrm.dao;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import com.hrm.domain.Job;
import com.hrm.domain.User;
import com.hrm.provider.JobDynaSqlProvider;
import com.hrm.provider.UserDynaSqlProvider;
public interface JobDao {
	//动态查找
	@SelectProvider(type=JobDynaSqlProvider.class,method="selectJob")
	public List<Job> selectJob(Job job);
	
	//将用户全部取出来放在map中
	@SelectProvider(type=JobDynaSqlProvider.class,method="countJob")
	public List<Job> countJob(Map params);
	//记录
	@Select("select count(*) from job_inf")
	public int countList();
	
	//根据id查找
	@Select("select * from job_inf where id=#{id}")
	Job selectById(int id);
	
	//查询所有
	@Select("select * from job_inf")
	List<Job> selectAllJob();
	
	//根据id删除
	@Delete("delete from job_inf where id=#{id}")
	public int deleteById(int id);
	
	//动态修改
	@SelectProvider(type=JobDynaSqlProvider.class,method="updateJob")
	public List<Job> updateJob(Job job);
	
	//动态插入
	@SelectProvider(type=JobDynaSqlProvider.class,method="insertJob")
	public void insertJob(Job job);
}