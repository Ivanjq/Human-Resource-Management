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
	//��̬����
	@SelectProvider(type=JobDynaSqlProvider.class,method="selectJob")
	public List<Job> selectJob(Job job);
	
	//���û�ȫ��ȡ��������map��
	@SelectProvider(type=JobDynaSqlProvider.class,method="countJob")
	public List<Job> countJob(Map params);
	//��¼
	@Select("select count(*) from job_inf")
	public int countList();
	
	//����id����
	@Select("select * from job_inf where id=#{id}")
	Job selectById(int id);
	
	//��ѯ����
	@Select("select * from job_inf")
	List<Job> selectAllJob();
	
	//����idɾ��
	@Delete("delete from job_inf where id=#{id}")
	public int deleteById(int id);
	
	//��̬�޸�
	@SelectProvider(type=JobDynaSqlProvider.class,method="updateJob")
	public List<Job> updateJob(Job job);
	
	//��̬����
	@SelectProvider(type=JobDynaSqlProvider.class,method="insertJob")
	public void insertJob(Job job);
}