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
	//��̬����
	@SelectProvider(type=NoticeDynaSqlProvider.class,method="selectNotice")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="CREATE_DATE",property="createDate",javaType=java.util.Date.class),
		@Result(column="USER_ID",property="user",
			one=@One(select="com.hrm.dao.UserDao.selectById",
			fetchType=FetchType.EAGER)),
	})
	public List<Notice> selectNotice(Notice notice);
	
	//���û�ȫ��ȡ��������map��
	@SelectProvider(type=NoticeDynaSqlProvider.class,method="countNotice")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="CREATE_DATE",property="createDate",javaType=java.util.Date.class),
		@Result(column="USER_ID",property="user",
			one=@One(select="com.hrm.dao.UserDao.selectById",
			fetchType=FetchType.EAGER)),
	})
	public List<Notice> countNotice(Map params);
	//��¼
	@Select("select count(*) from Notice_inf")
	public int countList();
	
	//����id����
	@Select("select * from notice_inf where id=#{id}")
	Notice selectById(int id);
	
	//����idɾ��
	@Delete("delete from notice_inf where id=#{id}")
	public int deleteById(int id);
	
	//��̬�޸�
	@SelectProvider(type=NoticeDynaSqlProvider.class,method="updateNotice")
	public List<Notice> updateNotice(Notice notice);
	
	//��̬����
	@SelectProvider(type=NoticeDynaSqlProvider.class,method="insertNotice")
	public void insertNotice(Notice notice);
}