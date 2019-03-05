package com.hrm.service;

import java.util.List;
import java.util.Map;

import com.hrm.domain.User;

public interface UserService {
	//User login(String loginname, String password);
	//用户登录
	User login(User user);
	//根据id查询用户
	public User findUserById(int id);
	//获取全部用户
	public List<User> selectUser(User user);
	//添加用户
	public void insertUser(User user);
	//根据id删除用户
	public int deleteById(int id);
	//修改用户
	public void updateUser(User user);
	//将用户全部取出来放在map中
	public List<User> countUser(Map params);
	//记录
	public int countList();
}
