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
	//���ݵ�¼���������ѯԱ��
	@Select("select * from user_inf where loginname=#{loginname} and password =#{password}")
//	public User login(@Param("loginname") String loginname,
//					  @Param("password") String password);
	public User login(User user);
	
	//��̬����
	@SelectProvider(type=UserDynaSqlProvider.class,method="selectUser")
	public List<User> selectUser(User user);
	
	//����id����
	@Select("select * from user_inf where id=#{id}")
	User selectById(int id);
	
	//����idɾ��
	@Delete("delete from user_inf where id=#{id}")
	public int deleteById(int id);
	
	//��̬�޸�
	@SelectProvider(type=UserDynaSqlProvider.class,method="updateUser")
	public List<User> updateUser(User user);
	
	//���û�ȫ��ȡ��������map��
	@SelectProvider(type=UserDynaSqlProvider.class,method="countUser")
	public List<User> countUser(Map params);
	//��¼
	@Select("select count(*) from user_inf")
	public int countList();
	
	//��̬����
	@SelectProvider(type=UserDynaSqlProvider.class,method="insertUser")
	public void insertUser(User user);
}