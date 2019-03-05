package com.hrm.dao;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import com.hrm.domain.Notice;
import com.hrm.domain.Salary;
import com.hrm.domain.User;
import com.hrm.provider.NoticeDynaSqlProvider;
import com.hrm.provider.SalaryDynaSqlProvider;
import com.hrm.provider.UserDynaSqlProvider;

public interface SalaryDao {
	//动态查找
	@SelectProvider(type=SalaryDynaSqlProvider.class,method="selectSalary")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="USER_ID",property="user",
			one=@One(select="com.hrm.dao.UserDao.selectById",
			fetchType=FetchType.EAGER)),
		@Result(column="DEPT_ID",property="dept",
			one=@One(select="com.hrm.dao.DeptDao.selectById",
			fetchType=FetchType.EAGER)),
		@Result(column="JOB_ID",property="job",
			one=@One(select="com.hrm.dao.JobDao.selectById",
			fetchType=FetchType.EAGER)),
	})
	public List<Salary> selectSalary(Salary salary);
	
	//将全部取出来放在map中
	@SelectProvider(type=SalaryDynaSqlProvider.class,method="countSalary")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="USER_ID",property="user",
				one=@One(select="com.hrm.dao.UserDao.selectById",
				fetchType=FetchType.EAGER)),
		@Result(column="DEPT_ID",property="dept",
				one=@One(select="com.hrm.dao.DeptDao.selectById",
				fetchType=FetchType.EAGER)),
		@Result(column="JOB_ID",property="job",
				one=@One(select="com.hrm.dao.JobDao.selectById",
				fetchType=FetchType.EAGER)),
	})
	public List<Salary> countSalary(Map params);
	//记录
	@Select("select count(*) from salary_inf")
	public int countList();
	
	//根据id查找
	@Select("select * from salary_inf where id=#{id}")
	Salary selectById(int id);
	
	//根据id删除
	@Delete("delete from salary_inf where id=#{id}")
	public int deleteById(int id);
	
	//动态修改
	@SelectProvider(type=SalaryDynaSqlProvider.class,method="updateSalary")
	public List<Salary> updateSalary(Salary salary);
	
	//动态插入
	@SelectProvider(type=SalaryDynaSqlProvider.class,method="insertSalary")
	public void insertSalary(Salary salary);
}