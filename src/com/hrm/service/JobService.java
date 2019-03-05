package com.hrm.service;

import java.util.List;
import java.util.Map;

import com.hrm.domain.Dept;
import com.hrm.domain.Job;
import com.hrm.domain.User;

public interface JobService {
	//����id��ѯְλ
	public Job selectById(int id);
	//��ȡ���е�ְλ
	List<Job> selectAllJob();
	//��ȡ��̬����
	public List<Job> selectJob(Job job);
	//���ְλ
	public void insertJob(Job job);
	//����idɾ��ְλ
	public int deleteById(int id);
	//�޸�ְλ
	public void updateJob(Job job);
	//���û�ȫ��ȡ��������map��
	public List<Job> countJob(Map params);
	//��¼
	public int countList();
	//��ѯȫ����ְλ
	public List<Job> findAllJob();
}
