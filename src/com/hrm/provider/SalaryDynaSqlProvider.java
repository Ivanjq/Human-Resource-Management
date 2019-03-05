package com.hrm.provider;

import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import com.hrm.domain.Salary;

public class SalaryDynaSqlProvider {
	//动态查找
	public String selectSalary(final Salary salary){
		return new SQL(){{
			SELECT("*");
			FROM("notice_inf");
			if(salary.getDept()!=null&&salary.getDept().getId()!=0){
				WHERE("dept_id=#{dept.id}");
			}
			if(salary.getJob()!=null&&salary.getJob().getId()!=0){
				WHERE("job_id=#{job.id}");
			}
		}}.toString();
	}
	//页面
	//select top pageSize* 
	//from notice_inf 
	//where id not in(select top (pageNow-1)*pageSize id from Notice_inf)
	public String countSalary(final Map params){
		return new SQL(){{
			Salary salary=(Salary)params.get("salary");
			Integer pageSize=(Integer) params.get("pageSize");
			Integer pageNow=(Integer) params.get("pageNow");
			String sql1=" top "+pageSize+" *";
			SELECT(sql1);
			FROM("salary_inf");
			if(salary!=null){
				if(salary.getDept()!=null&&salary.getDept().getId()!=0){
					WHERE("dept_id=#{salary.dept.id}");
				}
				if(salary.getJob()!=null&&salary.getJob().getId()!=0){
					WHERE("job_id=#{salary.job.id}");
				}
			}
			String sql2="id not in(select top "+(pageNow-1)*pageSize +" id from Salary_inf)";
			WHERE(sql2);
		}}.toString();
	}
	//动态插入
	public String insertSalary(final Salary salary){
		return new SQL(){{
			INSERT_INTO("salary_inf");
			if(salary.getDept()!=null&&salary.getDept().getId()!=0){
				VALUES("dept_id","#{dept.id}");
			}
			if(salary.getJob()!=null&&salary.getDept().getId()!=0){
				VALUES("job_id","#{job.id}");
			}
			if(salary.getSalary()!=null&&!salary.getSalary().equals("")){
				VALUES("salary","#{salary}");
			}
			if(salary.getUser()!=null&&!salary.getUser().equals("")){
				VALUES("user_id","#{user.id}");
			}
		}}.toString();
	}
	//动态更新
	public String updateSalary(final Salary salary){
		return new SQL(){{
			UPDATE("salary_inf");
			if(salary.getDept()!=null){
				SET("dept_id=#{dept.id}");
			}
			if(salary.getJob()!=null){
				SET("job_id=#{job.id}");
			}
			if(salary.getUser()!=null){
				SET("user_id=#{user.id}");
			}
			if(salary.getSalary()!=null){
				SET("salary=#{salary}");
			}
			WHERE("id=#{id}");
		}}.toString();
	}
}
