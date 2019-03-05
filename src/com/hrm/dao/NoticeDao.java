package com.hrm.dao;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import com.hrm.domain.Notice;
import com.hrm.domain.User;
import com.hrm.provider.NoticeDynaSqlProvider;
import com.hrm.provider.UserDynaSqlProvider;

public interface NoticeDao {
	//动态查找
	@SelectProvider(type=NoticeDynaSqlProvider.class,method="selectNotice")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="CREATE_DATE",property="createDate",javaType=java.util.Date.class),
		@Result(column="USER_ID",property="user",
			one=@One(select="com.hrm.dao.UserDao.selectById",
			fetchType=FetchType.EAGER)),
	})
	public List<Notice> selectNotice(Notice notice);
	
	//将用户全部取出来放在map中
	@SelectProvider(type=NoticeDynaSqlProvider.class,method="countNotice")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="CREATE_DATE",property="createDate",javaType=java.util.Date.class),
		@Result(column="USER_ID",property="user",
			one=@One(select="com.hrm.dao.UserDao.selectById",
			fetchType=FetchType.EAGER)),
	})
	public List<Notice> countNotice(Map params);
	//记录
	@Select("select count(*) from Notice_inf")
	public int countList();
	
	//根据id查找
	@Select("select * from notice_inf where id=#{id}")
	Notice selectById(int id);
	
	//根据id删除
	@Delete("delete from notice_inf where id=#{id}")
	public int deleteById(int id);
	
	//动态修改
	@SelectProvider(type=NoticeDynaSqlProvider.class,method="updateNotice")
	public List<Notice> updateNotice(Notice notice);
	
	//动态插入
	@SelectProvider(type=NoticeDynaSqlProvider.class,method="insertNotice")
	public void insertNotice(Notice notice);
}