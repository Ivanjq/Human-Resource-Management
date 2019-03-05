package com.hrm.dao;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import com.hrm.domain.Problem;
import com.hrm.domain.User;
import com.hrm.provider.ProblemDynaSqlProvider;
import com.hrm.provider.UserDynaSqlProvider;

public interface ProblemDao {
	//动态查找
	@SelectProvider(type=ProblemDynaSqlProvider.class,method="selectProblem")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="CREATE_DATE",property="createDate",javaType=java.util.Date.class),
		@Result(column="USER_ID",property="user",
			one=@One(select="com.hrm.dao.UserDao.selectById",
			fetchType=FetchType.EAGER)),
	})
	public List<Problem> selectProblem(Problem problem);
	
	//将用户全部取出来放在map中
	@SelectProvider(type=ProblemDynaSqlProvider.class,method="countProblem")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="CREATE_DATE",property="createDate",javaType=java.util.Date.class),
		@Result(column="USER_ID",property="user",
			one=@One(select="com.hrm.dao.UserDao.selectById",
			fetchType=FetchType.EAGER)),
	})
	public List<Problem> countProblem(Map params);
	//记录
	@Select("select count(*) from problem_inf")
	public int countList();
	
	//根据id查找
	@Select("select * from problem_inf where id=#{id}")
	Problem selectById(int id);
	
	//根据id删除
	@Delete("delete from problem_inf where id=#{id}")
	public int deleteById(int id);
	
	//动态修改
	@SelectProvider(type=ProblemDynaSqlProvider.class,method="updateProblem")
	public List<Problem> updateProblem(Problem problem);
	
	//动态插入
	@SelectProvider(type=ProblemDynaSqlProvider.class,method="insertProblem")
	public void insertProblem(Problem problem);
}