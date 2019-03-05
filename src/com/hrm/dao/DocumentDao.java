package com.hrm.dao;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import com.hrm.domain.Document;
import com.hrm.domain.User;
import com.hrm.provider.DocumentDynaSqlProvider;
import com.hrm.provider.UserDynaSqlProvider;

public interface DocumentDao {
	//动态查找
	@SelectProvider(type=DocumentDynaSqlProvider.class,method="selectDocument")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="CREATE_DATE",property="createDate",javaType=java.util.Date.class),
		@Result(column="USER_ID",property="user",
			one=@One(select="com.hrm.dao.UserDao.selectById",
			fetchType=FetchType.EAGER)),
	})
	public List<Document> selectDocument(Document document);
	
	//将全部取出来放在map中
	@SelectProvider(type=DocumentDynaSqlProvider.class,method="countDocument")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="CREATE_DATE",property="createDate",javaType=java.util.Date.class),
		@Result(column="USER_ID",property="user",
			one=@One(select="com.hrm.dao.UserDao.selectById",
			fetchType=FetchType.EAGER)),
	})
	public List<Document> countDocument(Map params);
	//记录
	@Select("select count(*) from document_inf")
	public int countList();
	
	//根据id查找
	@Select("select * from document_inf where id=#{id}")
	Document selectById(int id);
	
	//根据id删除
	@Delete("delete from document_inf where id=#{id}")
	public int deleteById(int id);
	
	//动态修改
	@SelectProvider(type=DocumentDynaSqlProvider.class,method="updateDocument")
	public List<Document> updateDocument(Document document);
	
	//动态插入
	@SelectProvider(type=DocumentDynaSqlProvider.class,method="insertDocument")
	public void insertDocument(Document document);
}