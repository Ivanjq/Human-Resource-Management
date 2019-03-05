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
	//动态查找
	@SelectProvider(type=DeptDynaSqlProvider.class,method="selectDept")
	public List<Dept> selectDept(Dept dept);
	
	//将全部取出来放在map中
	@SelectProvider(type=DeptDynaSqlProvider.class,method="countDept")
	public List<Dept> countDept(Map params);
	//记录
	@Select("select count(*) from dept_inf")
	public int countList();
	
	//根据id查找
	@Select("select * from dept_inf where id=#{id}")
	Dept selectById(int id);
	
	//查询所有
	@Select("select * from dept_inf")
	List<Dept> selectAllDept();
	
	//根据id删除
	@Delete("delete from dept_inf where id=#{id}")
	public int deleteById(int id);
	
	//动态修改
	@SelectProvider(type=DeptDynaSqlProvider.class,method="updateDept")
	public List<Dept> updateDept(Dept dept);
	
	//动态插入
	@SelectProvider(type=DeptDynaSqlProvider.class,method="insertDept")
	public void insertDept(Dept dept);
}