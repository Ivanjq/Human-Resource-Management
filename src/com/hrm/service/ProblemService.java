package com.hrm.service;

import java.util.List;
import java.util.Map;
import com.hrm.domain.Problem;

public interface ProblemService {
	//����id��ѯ
	public Problem selectById(int id);
	//��ȡ��̬����
	public List<Problem> selectProblem(Problem problem);
	//���
	public void insertProblem(Problem problem);
	//����idɾ��
	public int deleteById(int id);
	//�޸�
	public void updateProblem(Problem problem);
	//��ȫ��ȡ��������map��
	public List<Problem> countProblem(Map params);
	//��¼
	public int countList();
}
