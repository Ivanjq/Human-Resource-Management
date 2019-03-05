package com.hrm.service;

import java.util.List;
import java.util.Map;
import com.hrm.domain.Problem;

public interface ProblemService {
	//根据id查询
	public Problem selectById(int id);
	//获取动态查找
	public List<Problem> selectProblem(Problem problem);
	//添加
	public void insertProblem(Problem problem);
	//根据id删除
	public int deleteById(int id);
	//修改
	public void updateProblem(Problem problem);
	//将全部取出来放在map中
	public List<Problem> countProblem(Map params);
	//记录
	public int countList();
}
