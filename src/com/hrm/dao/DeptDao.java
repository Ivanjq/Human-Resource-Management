package com.hrm.dao;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import com.hrm.domain.Dept;
import com.hrm.domain.Job;
import com.hrm.domain.User;
import com.hrm.provider.DeptDynaSqlProvider;
import com.hrm.provider.UserDynaSqlProvider;

public interface DeptDao {
	//��̬����
	@SelectProvider(type=DeptDynaSqlProvider.class,method="selectDept")
	public List<Dept> selectDept(Dept dept);
	
	//��ȫ��ȡ��������map��
	@SelectProvider(type=DeptDynaSqlProvider.class,method="countDept")
	public List<Dept> countDept(Map params);
	//��¼
	@Select("select count(*) from dept_inf")
	public int countList();
	
	//����id����
	@Select("select * from dept_inf where id=#{id}")
	Dept selectById(int id);
	
	//��ѯ����
	@Select("select * from dept_inf")
	List<Dept> selectAllDept();
	
	//����idɾ��
	@Delete("delete from dept_inf where id=#{id}")
	public int deleteById(int id);
	
	//��̬�޸�
	@SelectProvider(type=DeptDynaSqlProvider.class,method="updateDept")
	public List<Dept> updateDept(Dept dept);
	
	//��̬����
	@SelectProvider(type=DeptDynaSqlProvider.class,method="insertDept")
	public void insertDept(Dept dept);
}