package com.hrm.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import com.hrm.domain.Dept;
import com.hrm.domain.User;

public class DeptDynaSqlProvider {
	//动态查找
	public String selectDept(final Dept dept){
		return new SQL(){{
			SELECT("*");
			FROM("dept_inf");
			if(dept.getName()!=null&&!dept.getName().equals("")){
				WHERE("name like '%'+#{name}+'%'");
			}
			if(dept.getRemark()!=null&&!dept.getRemark().equals("")){
				WHERE("remark like '%'+#{remark}+'%'");
			}
		}}.toString();
	}
	//页面
	//select top pageSize* 
	//from dept_inf 
	//where id not in(select top (pageNow-1)*pageSize id from Dept_inf)
	public String countDept(final Map params){
		return new SQL(){{
			Dept dept=(Dept)params.get("dept");
			Integer pageSize=(Integer) params.get("pageSize");
			Integer pageNow=(Integer) params.get("pageNow");
			String sql1=" top "+pageSize+" *";
			SELECT(sql1);
			FROM("dept_inf");
			if(dept!=null){
				if(dept.getName()!=null&&!dept.getName().equals("")){
					WHERE("name like '%'+#{dept.name}+'%'");
				}
				if(dept.getRemark()!=null&&!dept.getRemark().equals("")){
					WHERE("remark like '%'+#{dept.remark}+'%'");
				}
			}
			String sql2="id not in(select top "+(pageNow-1)*pageSize +" id from Dept_inf)";
			WHERE(sql2);
		}}.toString();
	}
	//动态插入
	public String insertDept(final Dept dept){
		return new SQL(){{
			INSERT_INTO("dept_inf");
			if(dept.getName()!=null&&!dept.getName().equals("")){
				VALUES("name","#{name}");
			}
			if(dept.getRemark()!=null&&!dept.getRemark().equals("")){
				VALUES("remark","#{remark}");
			}
		}}.toString();
	}
	//动态更新
	public String updateDept(final Dept dept){
		return new SQL(){{
			UPDATE("dept_inf");
			if(dept.getName()!=null&&!dept.getName().equals("")){
				SET("name=#{name}");
			}
			if(dept.getRemark()!=null&&!dept.getRemark().equals("")){
				SET("remark=#{remark}");
			}
			WHERE("id=#{id}");
		}}.toString();
	}
}
