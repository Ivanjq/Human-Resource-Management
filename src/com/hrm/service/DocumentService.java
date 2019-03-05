package com.hrm.service;

import java.util.List;
import java.util.Map;

import com.hrm.domain.Document;
import com.hrm.domain.User;

public interface DocumentService {
	//����id��ѯ����
	public Document selectById(int id);
	//��ȡ��̬����
	public List<Document> selectDocument(Document document);
	//��ӹ���
	public void insertDocument(Document document);
	//����idɾ������
	public int deleteById(int id);
	//�޸Ĺ���
	public void updateDocument(Document document);
	//���û�ȫ��ȡ��������map��
	public List<Document> countDocument(Map params);
	//��¼
	public int countList();
}
