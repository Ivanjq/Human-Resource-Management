package com.hrm.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.hrm.domain.Dept;
import com.hrm.domain.Notice;

public class NoticeDynaSqlProvider {
	//动态查找
	public String selectNotice(final Notice notice){
		return new SQL(){{
			SELECT("*");
			FROM("notice_inf");
			if(notice.getTitle()!=null&&!notice.getTitle().equals("")){
				WHERE("title like '%'+#{title}+'%'");
			}
			if(notice.getContent()!=null&&!notice.getContent().equals("")){
				WHERE("content like '%'+#{content}+'%'");
			}
		}}.toString();
	}
	//页面
	//select top pageSize* 
	//from notice_inf 
	//where id not in(select top (pageNow-1)*pageSize id from Notice_inf)
	public String countNotice(final Map params){
		return new SQL(){{
			Notice notice=(Notice)params.get("notice");
			Integer pageSize=(Integer) params.get("pageSize");
			Integer pageNow=(Integer) params.get("pageNow");
			String sql1=" top "+pageSize+" *";
			SELECT(sql1);
			FROM("notice_inf");
			if(notice!=null){
				if(notice.getTitle()!=null&&!notice.getTitle().equals("")){
					WHERE("title like '%'+#{notice.title}+'%'");
				}
				if(notice.getContent()!=null&&!notice.getContent().equals("")){
					WHERE("content like '%'+#{notice.content}+'%'");
				}
			}
			String sql2="id not in(select top "+(pageNow-1)*pageSize +" id from Notice_inf)";
			WHERE(sql2);
		}}.toString();
	}
	//动态插入
	public String insertNotice(final Notice notice){
		return new SQL(){{
			INSERT_INTO("notice_inf");
			if(notice.getTitle()!=null&&!notice.getTitle().equals("")){
				VALUES("title","#{title}");
			}
			if(notice.getContent()!=null&&!notice.getContent().equals("")){
				VALUES("content","#{content}");
			}
			if(notice.getUser()!=null&&!notice.getUser().equals("")){
				VALUES("user_id","#{user.id}");
			}
		}}.toString();
	}
	//动态更新
	public String updateNotice(final Notice notice){
		return new SQL(){{
			UPDATE("notice_inf");
			if(notice.getTitle()!=null&&!notice.getTitle().equals("")){
				SET("title =#{title}");
			}
			if(notice.getContent()!=null&&!notice.getContent().equals("")){
				SET("content =#{content}");
			}
			if(notice.getUser()!=null&&!notice.getUser().equals("")){
				SET("user_id =#{user.id}");
			}
			WHERE("id=#{id}");
		}}.toString();
	}
}
