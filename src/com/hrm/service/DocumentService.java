package com.hrm.service;

import java.util.List;
import java.util.Map;

import com.hrm.domain.Document;
import com.hrm.domain.User;

public interface DocumentService {
	//根据id查询公告
	public Document selectById(int id);
	//获取动态查找
	public List<Document> selectDocument(Document document);
	//添加公告
	public void insertDocument(Document document);
	//根据id删除公告
	public int deleteById(int id);
	//修改公告
	public void updateDocument(Document document);
	//将用户全部取出来放在map中
	public List<Document> countDocument(Map params);
	//记录
	public int countList();
}
