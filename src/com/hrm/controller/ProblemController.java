package com.hrm.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hrm.domain.Dept;
import com.hrm.domain.Problem;
import com.hrm.domain.Pages;
import com.hrm.domain.User;
import com.hrm.service.ProblemService;

/*�����û����������*/
@Controller
public class ProblemController {
	/*�Զ�ע��ProblemService*/
	@Autowired
	@Qualifier("problemService")
	//@Resource("ProblemService")
	ProblemService problemService;
	//��̬��ѯ
	@RequestMapping("main/selectProblem")
	public String countProblem(Problem problem,Model model,Integer pageNow){
		Map params=new HashMap();
		if(pageNow==null) pageNow=1;
			params.put("problem",problem);
			params.put("pageSize",pageSize);
			params.put("pageNow",pageNow);
		int totalSize=problemService.countList();
		Pages page=new Pages(pageNow,pageSize,totalSize);
		System.out.println(pageNow+""+pageSize+""+totalSize);
		List<Problem> list=problemService.countProblem(params);
		model.addAttribute("problemList",list);
		model.addAttribute("page",page);
		return "problem/lookProblemself";
	}
	int pageSize=3;
	//��̬��ѯ
	@RequestMapping("main/selectProblem2")
	public String countProblem2(Problem problem,Model model,Integer pageNow){
		Map params=new HashMap();
		if(pageNow==null) pageNow=1;
			params.put("problem",problem);
			params.put("pageSize",pageSize);
			params.put("pageNow",pageNow);
		int totalSize=problemService.countList();
		Pages page=new Pages(pageNow,pageSize,totalSize);
		System.out.println(pageNow+""+pageSize+""+totalSize);
		List<Problem> list=problemService.countProblem(params);
		model.addAttribute("problemList",list);
		model.addAttribute("page",page);
		return "problem/lookProblem";
	}
	//����
	@RequestMapping("problem/insertProblem")
	public String insertProblem(Problem problem,User user){
		problem.setUser(user);
		Date createDate=new Date();
		problem.setCreateDate(createDate);
		problemService.insertProblem(problem);
		return "redirect:../main/selectProblem2";
	}
	//ɾ��
	@RequestMapping("/deleteProblem")
	public String deleteProblem(int id){
		problemService.deleteById(id);
		return "redirect:main/selectProblem2";
	}
	//�޸� 
	@RequestMapping("/updateProblem")
	public String updateProblem(Problem problem,Model model){
		//����id��ѯ ����ҳ��
		Problem target=problemService.selectById(problem.getId());
		model.addAttribute("problem",target);
		return "problem/problem_update";
	}
	@RequestMapping("/updateProblemView")
	public String updateProblemView(Problem problem){
		problemService.updateProblem(problem);
		return "redirect:main/selectProblem2";
	}
}
