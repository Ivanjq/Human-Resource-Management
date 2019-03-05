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
	//用户登录
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		System.out.println("HrmServiceImpl login-->>");
		return userDao.login(user);
	}
	//查询所有用户
	@Override
	public List<User> selectUser(User user) {
		// TODO Auto-generated method stub
		return userDao.selectUser(user);
	}
	//根据id删除用户
	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return userDao.deleteById(id);
	}
	//根据id查询用户
	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		return userDao.selectById(id);
	}
	//添加用户
	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		userDao.insertUser(user);
	}
	//修改用户
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userDao.updateUser(user);
	}
	//将用户全部取出来放在map中
	@Override
	public List<User> countUser(Map params) {
		// TODO Auto-generated method stub
		return userDao.countUser(params);
	}
	//记录
	@Override
	public int countList() {
		// TODO Auto-generated method stub
		return userDao.countList();
	}
	
	
}
