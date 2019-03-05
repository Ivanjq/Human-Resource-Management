package com.hrm.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.hrm.domain.Dept;
import com.hrm.domain.Job;

public class JobDynaSqlProvider {
	//动态查找
	public String selectJob(final Job job){
		return new SQL(){{
			SELECT("*");
			FROM("job_inf");
			if(job.getName()!=null&&!job.getName().equals("")){
				WHERE("name like '%'+#{name}+'%'");
			}
			if(job.getRemark()!=null&&!job.getRemark().equals("")){
				WHERE("remark like '%'+#{remark}+'%'");
			}
		}}.toString();
	}
	//页面
	//select top pageSize* 
	//from job_inf 
	//where id not in(select top (pageNow-1)*pageSize id from Job_inf)
	public String countJob(final Map params){
		return new SQL(){{
			Job job=(Job)params.get("job");
			Integer pageSize=(Integer) params.get("pageSize");
			Integer pageNow=(Integer) params.get("pageNow");
			String sql1=" top "+pageSize+" *";
			SELECT(sql1);
			FROM("job_inf");
			if(job!=null){
				if(job.getName()!=null&&!job.getName().equals("")){
					WHERE("name like '%'+#{job.name}+'%'");
				}
				if(job.getRemark()!=null&&!job.getRemark().equals("")){
					WHERE("remark like '%'+#{job.remark}+'%'");
				}
			}
			String sql2="id not in(select top "+(pageNow-1)*pageSize +" id from Job_inf)";
			WHERE(sql2);
		}}.toString();
	}
	//动态插入
	public String insertJob(final Job job){
		return new SQL(){{
			INSERT_INTO("job_inf");
			if(job.getName()!=null&&!job.getName().equals("")){
				VALUES("name","#{name}");
			}
			if(job.getRemark()!=null&&!job.getRemark().equals("")){
				VALUES("remark","#{remark}");
			}
		}}.toString();
	}
	//动态更新
	public String updateJob(final Job job){
		return new SQL(){{
			UPDATE("job_inf");
			if(job.getName()!=null&&!job.getName().equals("")){
				SET("name=#{name}");
			}
			if(job.getRemark()!=null&&!job.getRemark().equals("")){
				SET("remark=#{remark}");
			}
			WHERE("id=#{id}");
		}}.toString();
	}
}
