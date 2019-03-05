package com.hrm.dao;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import com.hrm.domain.User;
import com.hrm.provider.UserDynaSqlProvider;

public interface UserDao {
	//根据登录名和密码查询员工
	@Select("select * from user_inf where loginname=#{loginname} and password =#{password}")
//	public User login(@Param("loginname") String loginname,
//					  @Param("password") String password);
	public User login(User user);
	
	//动态查找
	@SelectProvider(type=UserDynaSqlProvider.class,method="selectUser")
	public List<User> selectUser(User user);
	
	//根据id查找
	@Select("select * from user_inf where id=#{id}")
	User selectById(int id);
	
	//根据id删除
	@Delete("delete from user_inf where id=#{id}")
	public int deleteById(int id);
	
	//动态修改
	@SelectProvider(type=UserDynaSqlProvider.class,method="updateUser")
	public List<User> updateUser(User user);
	
	//将用户全部取出来放在map中
	@SelectProvider(type=UserDynaSqlProvider.class,method="countUser")
	public List<User> countUser(Map params);
	//记录
	@Select("select count(*) from user_inf")
	public int countList();
	
	//动态插入
	@SelectProvider(type=UserDynaSqlProvider.class,method="insertUser")
	public void insertUser(User user);
}