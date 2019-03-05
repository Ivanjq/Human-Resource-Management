package com.hrm.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import com.hrm.domain.User;

public class UserDynaSqlProvider {
	//动态查找用户
	public String selectUser(final User user){
		return new SQL(){{
			SELECT("*");
			FROM("user_inf");
			if(user.getUsername()!=null&&!user.getUsername().equals("")){
				WHERE("username like '%'+#{username}+'%'");
			}
			if(user.getStatus()!=null&&!user.getStatus().equals("")){
				WHERE("status=#{status}");
			}
		}}.toString();
	}
	//页面
	//select top pageSize* 
	//from user_inf 
	//where id not in(select top (pageNow-1)*pageSize id from User_inf)
	public String countUser(final Map params){
		return new SQL(){{
			User user=(User)params.get("user");
			Integer pageSize=(Integer) params.get("pageSize");
			Integer pageNow=(Integer) params.get("pageNow");
			String sql1=" top "+pageSize+" *";
			SELECT(sql1);
			FROM("user_inf");
			if(user!=null){
				if(user.getUsername()!=null&&!user.getUsername().equals("")){
					WHERE("username like '%'+#{user.username}+'%'");
				}
				if(user.getStatus()!=null&&!user.getStatus().equals("")){
					WHERE("status=#{user.status}");
				}
			}
			String sql2="id not in(select top "+(pageNow-1)*pageSize +" id from User_inf)";
			WHERE(sql2);
		}}.toString();
	}
	//动态插入
	public String insertUser(final User user){
		return new SQL(){{
			INSERT_INTO("user_inf");
			if(user.getUsername()!=null&&!user.getUsername().equals("")){
				VALUES("username","#{username}");
			}
			if(user.getStatus()!=null&&!user.getStatus().equals("")){
				VALUES("status","#{status}");
			}
			if(user.getLoginname()!=null&&!user.getLoginname().equals("")){
				VALUES("loginname","#{loginname}");
			}
			if(user.getPassword()!=null&&!user.getPassword().equals("")){
				VALUES("password","#{password}");
			}
			if(user.getCreatedate()!=null&&!user.getCreatedate().equals("")){
				VALUES("createdate","#{createdate}");
			}
		}}.toString();
	}
	//动态更新
	public String updateUser(final User user){
		return new SQL(){{
			UPDATE("user_inf");
			if(user.getUsername()!=null&&!user.getUsername().equals("")){
				SET("username=#{username}");
			}
			if(user.getStatus()!=null&&!user.getStatus().equals("")){
				SET("status=#{status}");
			}
			if(user.getLoginname()!=null&&!user.getLoginname().equals("")){
				SET("loginname=#{loginname}");
			}
			if(user.getPassword()!=null&&!user.getPassword().equals("")){
				SET("password=#{password}");
			}
			if(user.getCreatedate()!=null&&!user.getCreatedate().equals("")){
				SET("createdate=#{createdate}");
			}
			WHERE("id=#{id}");
		}}.toString();
	}
}
