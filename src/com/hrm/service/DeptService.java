package com.hrm.service;

import java.util.List;
import java.util.Map;

import com.hrm.domain.Dept;
import com.hrm.domain.User;

public interface DeptService {
	//����id��ѯ����
	public Dept selectById(int id);
	//��ȡ��̬����
	public List<Dept> selectDept(Dept dept);
	//��Ӳ���
	public void insertDept(Dept dept);
	//����idɾ������
	public int deleteById(int id);
	//�޸Ĳ���
	public void updateDept(Dept dept);
	//���û�ȫ��ȡ��������map��
	public List<Dept> countDept(Map params);
	//��¼
	public int countList();
	//��ѯȫ���Ĳ���
	public List<Dept> findAllDept();
}
