package com.hrm.domain;

import org.springframework.web.multipart.MultipartFile;

public class Document {
	private int id;              //���
	private String title;        //����
	private String filename;     //�ļ���
	private MultipartFile file;  //�ļ�
	private String remark;       //����
	private java.util.Date createDate;  //�ϴ�ʱ��
	private User user;                  //�ϴ���
	
	public Document(){
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public java.util.Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
