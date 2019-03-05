package com.hrm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hrm.dao.UserDao;
import com.hrm.domain.User;
import com.hrm.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;
//	public User login(String loginname,String password){
//		System.out.println("HrmServiceImpl login-->>");
//		return userDao.login(loginname, password);
//	}
	//�û���¼
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		System.out.println("HrmServiceImpl login-->>");
		return userDao.login(user);
	}
	//��ѯ�����û�
	@Override
	public List<User> selectUser(User user) {
		// TODO Auto-generated method stub
		return userDao.selectUser(user);
	}
	//����idɾ���û�
	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return userDao.deleteById(id);
	}
	//����id��ѯ�û�
	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		return userDao.selectById(id);
	}
	//����û�
	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		userDao.insertUser(user);
	}
	//�޸��û�
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userDao.updateUser(user);
	}
	//���û�ȫ��ȡ��������map��
	@Override
	public List<User> countUser(Map params) {
		// TODO Auto-generated method stub
		return userDao.countUser(params);
	}
	//��¼
	@Override
	public int countList() {
		// TODO Auto-generated method stub
		return userDao.countList();
	}
	
	
}
