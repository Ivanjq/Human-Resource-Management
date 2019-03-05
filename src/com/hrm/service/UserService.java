package com.hrm.service;

import java.util.List;
import java.util.Map;

import com.hrm.domain.User;

public interface UserService {
	//User login(String loginname, String password);
	//�û���¼
	User login(User user);
	//����id��ѯ�û�
	public User findUserById(int id);
	//��ȡȫ���û�
	public List<User> selectUser(User user);
	//����û�
	public void insertUser(User user);
	//����idɾ���û�
	public int deleteById(int id);
	//�޸��û�
	public void updateUser(User user);
	//���û�ȫ��ȡ��������map��
	public List<User> countUser(Map params);
	//��¼
	public int countList();
}
