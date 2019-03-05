package com.hrm.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.hrm.domain.Dept;
import com.hrm.domain.Employee;

public class EmployeeDynaSqlProvider {
	//动态查找
	public String selectEmployee(final Employee employee){
		return new SQL(){{
			SELECT("*");
			FROM("employee_inf");
			if(employee.getDept()!=null&&employee.getDept().getId()!=0){
				WHERE("dept_id=#{dept.id}");
			}
			if(employee.getJob()!=null&&employee.getJob().getId()!=0){
				WHERE("job_id=#{job.id}");
			}
			if(employee.getName()!=null&&!employee.getName().equals("")){
				WHERE("name like '%'+#{name}+'%'");
			}
			if(employee.getPhone()!=null&&!employee.getPhone().equals("")){
				WHERE("phone like '%'+#{phone}+'%'");
			}
			if(employee.getCardId()!=null&&!employee.getCardId().equals("")){
				WHERE("card_id like '%'+#{cardId}+'%'");
			}
			if(employee.getSex()!=null&&!employee.getSex().equals("")){
				WHERE("sex =#{sex}");
			}
		}}.toString();
	}
	//页面
	//select top pageSize* 
	//from employee_inf 
	//where id not in(select top (pageNow-1)*pageSize id from Employee_inf)
	public String countEmployee(final Map params){
		return new SQL(){{
			Employee employee=(Employee)params.get("employee");
			Integer pageSize=(Integer) params.get("pageSize");
			Integer pageNow=(Integer) params.get("pageNow");
			String sql1=" top "+pageSize+" *";
			SELECT(sql1);
			FROM("employee_inf");
			if(employee!=null){
				if(employee.getDept()!=null&&employee.getDept().getId()!=0){
					WHERE("dept_id=#{employee.dept.id}");
				}
				if(employee.getJob()!=null&&employee.getJob().getId()!=0){
					WHERE("job_id=#{employee.job.id}");
				}
				if(employee.getName()!=null&&!employee.getName().equals("")){
					WHERE("name like '%'+#{employee.name}+'%'");
				}
				if(employee.getPhone()!=null&&!employee.getPhone().equals("")){
					WHERE("phone like '%'+#{employee.phone}+'%'");
				}
				if(employee.getCardId()!=null&&!employee.getCardId().equals("")){
					WHERE("card_id like '%'+#{employee.cardId}+'%'");
				}
				if(employee.getSex()!=null&&!employee.getSex().equals("")){
					WHERE("sex =#{employee.sex}");
				}
			}
			String sql2="id not in(select top "+(pageNow-1)*pageSize +" id from Employee_inf)";
			WHERE(sql2);
		}}.toString();
	}
	//动态插入
	public String insertEmployee(final Employee employee){
		return new SQL(){{
			INSERT_INTO("employee_inf");
			if(employee.getName()!=null){
				VALUES("name","#{name}");
			}
			if(employee.getCardId()!=null){
				VALUES("card_id","#{cardId}");
			}
			if(employee.getAddress()!=null){
				VALUES("address","#{address}");
			}
			if(employee.getPostCode()!=null){
				VALUES("post_code","#{postCode}");
			}
			if(employee.getTel()!=null){
				VALUES("tel","#{tel}");
			}
			if(employee.getPhone()!=null){
				VALUES("phone","#{phone}");
			}
			if(employee.getQqNum()!=null){
				VALUES("qq_num","#{qqNum}");
			}
			if(employee.getEmail()!=null){
				VALUES("email","#{email}");
			}
			if(employee.getSex()!=null){
				VALUES("sex","#{sex}");
			}
			if(employee.getParty()!=null){
				VALUES("party","#{party}");
			}
			if(employee.getBirthday()!=null){
				VALUES("birthday","#{birthday}");
			}
			if(employee.getEducation()!=null){
				VALUES("education","#{education}");
			}
			if(employee.getSpeciality()!=null){
				VALUES("speciality","#{speciality}");
			}
			if(employee.getHobby()!=null){
				VALUES("hobby","#{hobby}");
			}
			if(employee.getRace()!=null){
				VALUES("race","#{race}");
			}
			if(employee.getRemark()!=null){
				VALUES("remark","#{remark}");
			}
			if(employee.getCreateDate()!=null){
				VALUES("create_Date","#{createDate}");
			}
			if(employee.getDept()!=null){
				VALUES("dept_id","#{dept.id}");
			}
			if(employee.getJob()!=null){
				VALUES("job_id","#{job.id}");
			}
		}}.toString();
	}
	//动态更新
	public String updateEmployee(final Employee employee){
		return new SQL(){{
			UPDATE("employee_inf");
			if(employee.getName()!=null){
				SET("name=#{name}");
			}
			if(employee.getCardId()!=null){
				SET("card_id=#{cardId}");
			}
			if(employee.getAddress()!=null){
				SET("address=#{address}");
			}
			if(employee.getPostCode()!=null){
				SET("post_code=#{postCode}");
			}
			if(employee.getTel()!=null){
				SET("tel=#{tel}");
			}
			if(employee.getPhone()!=null){
				SET("phone=#{phone}");
			}
			if(employee.getQqNum()!=null){
				SET("qq_num=#{qqNum}");
			}
			if(employee.getEmail()!=null){
				SET("email=#{email}");
			}
			if(employee.getSex()!=null){
				SET("sex=#{sex}");
			}
			if(employee.getParty()!=null){
				SET("party=#{party}");
			}
			if(employee.getBirthday()!=null){
				SET("birthday=#{birthday}");
			}
			if(employee.getEducation()!=null){
				SET("education=#{education}");
			}
			if(employee.getSpeciality()!=null){
				SET("speciality=#{speciality}");
			}
			if(employee.getHobby()!=null){
				SET("hobby=#{hobby}");
			}
			if(employee.getRemark()!=null){
				SET("remark=#{remark}");
			}
			if(employee.getCreateDate()!=null){
				SET("create_Date=#{createDate}");
			}
			if(employee.getDept()!=null){
				SET("dept_id=#{dept.id}");
			}
			if(employee.getJob()!=null){
				SET("job_id=#{job.id}");
			}
			WHERE("id=#{id}");
		}}.toString();
	}
}
