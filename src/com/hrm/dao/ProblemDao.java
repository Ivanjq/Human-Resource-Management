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
	//��̬����
	@SelectProvider(type=ProblemDynaSqlProvider.class,method="selectProblem")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="CREATE_DATE",property="createDate",javaType=java.util.Date.class),
		@Result(column="USER_ID",property="user",
			one=@One(select="com.hrm.dao.UserDao.selectById",
			fetchType=FetchType.EAGER)),
	})
	public List<Problem> selectProblem(Problem problem);
	
	//���û�ȫ��ȡ��������map��
	@SelectProvider(type=ProblemDynaSqlProvider.class,method="countProblem")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="CREATE_DATE",property="createDate",javaType=java.util.Date.class),
		@Result(column="USER_ID",property="user",
			one=@One(select="com.hrm.dao.UserDao.selectById",
			fetchType=FetchType.EAGER)),
	})
	public List<Problem> countProblem(Map params);
	//��¼
	@Select("select count(*) from problem_inf")
	public int countList();
	
	//����id����
	@Select("select * from problem_inf where id=#{id}")
	Problem selectById(int id);
	
	//����idɾ��
	@Delete("delete from problem_inf where id=#{id}")
	public int deleteById(int id);
	
	//��̬�޸�
	@SelectProvider(type=ProblemDynaSqlProvider.class,method="updateProblem")
	public List<Problem> updateProblem(Problem problem);
	
	//��̬����
	@SelectProvider(type=ProblemDynaSqlProvider.class,method="insertProblem")
	public void insertProblem(Problem problem);
}