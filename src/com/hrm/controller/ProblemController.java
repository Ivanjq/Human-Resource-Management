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

/*处理用户请求控制器*/
@Controller
public class ProblemController {
	/*自动注入ProblemService*/
	@Autowired
	@Qualifier("problemService")
	//@Resource("ProblemService")
	ProblemService problemService;
	//动态查询
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
	//动态查询
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
	//插入
	@RequestMapping("problem/insertProblem")
	public String insertProblem(Problem problem,User user){
		problem.setUser(user);
		Date createDate=new Date();
		problem.setCreateDate(createDate);
		problemService.insertProblem(problem);
		return "redirect:../main/selectProblem2";
	}
	//删除
	@RequestMapping("/deleteProblem")
	public String deleteProblem(int id){
		problemService.deleteById(id);
		return "redirect:main/selectProblem2";
	}
	//修改 
	@RequestMapping("/updateProblem")
	public String updateProblem(Problem problem,Model model){
		//根据id查询 返回页面
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
