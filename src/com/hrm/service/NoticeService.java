package com.hrm.service;

import java.util.List;
import java.util.Map;

import com.hrm.domain.Notice;
import com.hrm.domain.User;

public interface NoticeService {
	//根据id查询公告
	public Notice selectById(int id);
	//获取动态查找
	public List<Notice> selectNotice(Notice notice);
	//添加公告
	public void insertNotice(Notice notice);
	//根据id删除公告
	public int deleteById(int id);
	//修改公告
	public void updateNotice(Notice notice);
	//将用户全部取出来放在map中
	public List<Notice> countNotice(Map params);
	//记录
	public int countList();
}
