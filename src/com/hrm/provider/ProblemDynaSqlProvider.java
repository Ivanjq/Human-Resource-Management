package com.hrm.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.hrm.domain.Dept;
import com.hrm.domain.Problem;

public class ProblemDynaSqlProvider {
	//动态查找
	public String selectProblem(final Problem problem){
		return new SQL(){{
			SELECT("*");
			FROM("problem_inf");
			if(problem.getTitle()!=null&&!problem.getTitle().equals("")){
				WHERE("title like '%'+#{title}+'%'");
			}
			if(problem.getContent()!=null&&!problem.getContent().equals("")){
				WHERE("content like '%'+#{content}+'%'");
			}
		}}.toString();
	}
	//页面
	//select top pageSize* 
	//from problem_inf 
	//where id not in(select top (pageNow-1)*pageSize id from Problem_inf)
	public String countProblem(final Map params){
		return new SQL(){{
			Problem problem=(Problem)params.get("problem");
			Integer pageSize=(Integer) params.get("pageSize");
			Integer pageNow=(Integer) params.get("pageNow");
			String sql1=" top "+pageSize+" *";
			SELECT(sql1);
			FROM("problem_inf");
			if(problem!=null){
				if(problem.getTitle()!=null&&!problem.getTitle().equals("")){
					WHERE("title like '%'+#{problem.title}+'%'");
				}
				if(problem.getContent()!=null&&!problem.getContent().equals("")){
					WHERE("content like '%'+#{problem.content}+'%'");
				}
			}
			String sql2="id not in(select top "+(pageNow-1)*pageSize +" id from Problem_inf)";
			WHERE(sql2);
		}}.toString();
	}
	//动态插入
	public String insertProblem(final Problem problem){
		return new SQL(){{
			INSERT_INTO("problem_inf");
			if(problem.getTitle()!=null&&!problem.getTitle().equals("")){
				VALUES("title","#{title}");
			}
			if(problem.getContent()!=null&&!problem.getContent().equals("")){
				VALUES("content","#{content}");
			}
			if(problem.getUser()!=null&&!problem.getUser().equals("")){
				VALUES("user_id","#{user.id}");
			}
		}}.toString();
	}
	//动态更新
	public String updateProblem(final Problem problem){
		return new SQL(){{
			UPDATE("problem_inf");
			if(problem.getTitle()!=null&&!problem.getTitle().equals("")){
				SET("title =#{title}");
			}
			if(problem.getContent()!=null&&!problem.getContent().equals("")){
				SET("content =#{content}");
			}
			if(problem.getUser()!=null&&!problem.getUser().equals("")){
				SET("user_id =#{user.id}");
			}
			WHERE("id=#{id}");
		}}.toString();
	}
}
