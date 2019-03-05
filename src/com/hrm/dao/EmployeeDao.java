package com.hrm.dao;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import com.hrm.domain.Employee;
import com.hrm.provider.EmployeeDynaSqlProvider;

public interface EmployeeDao {
	//动态查找
	@SelectProvider(type=EmployeeDynaSqlProvider.class,method="selectEmployee")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="CARD_ID",property="cardId"),
		@Result(column="POST_CODE",property="postCode"),
		@Result(column="QQ_NUM",property="qqNum"),
		@Result(column="BIRTHDAY",property="birthday",javaType=java.util.Date.class),
		@Result(column="CREATE_DATE",property="createDate",javaType=java.util.Date.class),
		@Result(column="DEPT_ID",property="dept",
			one=@One(select="com.hrm.dao.DeptDao.selectById",
			fetchType=FetchType.EAGER)),
		@Result(column="JOB_ID",property="job",
			one=@One(select="com.hrm.dao.JobDao.selectById",
			fetchType=FetchType.EAGER)),
	})
	public List<Employee> selectEmployee(Employee employee);
	
	//将用户全部取出来放在map中
	@SelectProvider(type=EmployeeDynaSqlProvider.class,method="countEmployee")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="CARD_ID",property="cardId"),
		@Result(column="POST_CODE",property="postCode"),
		@Result(column="QQ_NUM",property="qqNum"),
		@Result(column="BIRTHDAY",property="birthday",javaType=java.util.Date.class),
		@Result(column="CREATE_DATE",property="createDate",javaType=java.util.Date.class),
		@Result(column="DEPT_ID",property="dept",
			one=@One(select="com.hrm.dao.DeptDao.selectById",
			fetchType=FetchType.EAGER)),
		@Result(column="JOB_ID",property="job",
			one=@One(select="com.hrm.dao.JobDao.selectById",
			fetchType=FetchType.EAGER)),
	})
	public List<Employee> countEmployee(Map params);
	//记录
	@Select("select count(*) from employee_inf")
	public int countList();
	
	//根据id查找
	@Select("select * from employee_inf where id=#{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="CARD_ID",property="cardId"),
		@Result(column="POST_CODE",property="postCode"),
		@Result(column="QQ_NUM",property="qqNum"),
		@Result(column="BIRTHDAY",property="birthday",javaType=java.util.Date.class),
		@Result(column="CREATE_DATE",property="createDate",javaType=java.util.Date.class),
		@Result(column="DEPT_ID",property="dept",
			one=@One(select="com.hrm.dao.DeptDao.selectById",
			fetchType=FetchType.EAGER)),
		@Result(column="JOB_ID",property="job",
			one=@One(select="com.hrm.dao.JobDao.selectById",
			fetchType=FetchType.EAGER)),
	})
	Employee selectById(int id);
	
	//根据id删除
	@Delete("delete from employee_inf where id=#{id}")
	public int deleteById(int id);
	
	//动态修改
	@SelectProvider(type=EmployeeDynaSqlProvider.class,method="updateEmployee")
	public List<Employee> updateEmployee(Employee employee);
	
	//动态插入
	@SelectProvider(type=EmployeeDynaSqlProvider.class,method="insertEmployee")
	public void insertEmployee(Employee employee);
}