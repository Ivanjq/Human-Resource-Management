package com.hrm.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.hrm.domain.Dept;
import com.hrm.domain.Document;

public class DocumentDynaSqlProvider {
	//动态查找
	public String selectDocument(final Document document){
		return new SQL(){{
			SELECT("*");
			FROM("document_inf");
			if(document.getTitle()!=null&&!document.getTitle().equals("")){
				WHERE("title like '%'+#{title}+'%'");
			}
		}}.toString();
	}
	//页面
	//select top pageSize* 
	//from document_inf 
	//where id not in(select top (pageNow-1)*pageSize id from Document_inf)
	public String countDocument(final Map params){
		return new SQL(){{
			Document document=(Document)params.get("document");
			Integer pageSize=(Integer) params.get("pageSize");
			Integer pageNow=(Integer) params.get("pageNow");
			String sql1=" top "+pageSize+" *";
			SELECT(sql1);
			FROM("document_inf");
			if(document!=null){
				if(document.getTitle()!=null&&!document.getTitle().equals("")){
					WHERE("title like '%'+#{document.title}+'%'");
				}
			}
			String sql2="id not in(select top "+(pageNow-1)*pageSize +" id from Document_inf)";
			WHERE(sql2);
		}}.toString();
	}
	//动态插入
	public String insertDocument(final Document document){
		return new SQL(){{
			INSERT_INTO("document_inf");
			if(document.getTitle()!=null&&!document.getTitle().equals("")){
				VALUES("title","#{title}");
			}
			if(document.getFilename()!=null&&!document.getFilename().equals("")){
				VALUES("filename","#{filename}");
			}
			if(document.getRemark()!=null&&!document.getRemark().equals("")){
				VALUES("remark","#{remark}");
			}
			if(document.getCreateDate()!=null&&document.getCreateDate().equals("")){
				VALUES("create_date","#{createDate}");
			}
			if(document.getUser()!=null&&!document.getUser().equals("")){
				VALUES("user_id","#{user.id}");
			}
		}}.toString();
	}
	//动态更新
	public String updateDocument(final Document document){
		return new SQL(){{
			UPDATE("document_inf");
			if(document.getTitle()!=null&&!document.getTitle().equals("")){
				SET("title =#{title}");
			}
			if(document.getRemark()!=null&&!document.getRemark().equals("")){
				SET("remark =#{remark}");
			}
			if(document.getUser()!=null&&!document.getUser().equals("")){
				SET("user_id =#{user.id}");
			}
			WHERE("id=#{id}");
		}}.toString();
	}
}
