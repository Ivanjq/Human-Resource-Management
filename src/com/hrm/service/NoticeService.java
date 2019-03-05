package com.hrm.service;

import java.util.List;
import java.util.Map;

import com.hrm.domain.Notice;
import com.hrm.domain.User;

public interface NoticeService {
	//����id��ѯ����
	public Notice selectById(int id);
	//��ȡ��̬����
	public List<Notice> selectNotice(Notice notice);
	//��ӹ���
	public void insertNotice(Notice notice);
	//����idɾ������
	public int deleteById(int id);
	//�޸Ĺ���
	public void updateNotice(Notice notice);
	//���û�ȫ��ȡ��������map��
	public List<Notice> countNotice(Map params);
	//��¼
	public int countList();
}
