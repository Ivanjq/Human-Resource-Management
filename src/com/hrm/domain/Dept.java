package com.hrm.domain;

public class Dept {
	private int id;   //部门id
	private String name;  //部门名称
	private String remark;//详细描述
	public Dept(){
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
