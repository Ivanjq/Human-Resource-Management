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
import com.hrm.domain.Pages;
import com.hrm.domain.User;
import com.hrm.service.DeptService;

/*处理用户请求控制器*/
@Controller
public class DeptController {
	/*自动注入DeptService*/
	@Autowired
	@Qualifier("deptService")
	//@Resource("DeptService")
	DeptService deptService;
	//动态查询
	@RequestMapping("main/selectDept")
	public String selectDept(Dept dept,Model model){
		List<Dept> list=deptService.selectDept(dept);
		for(Dept dept2:list){
			System.out.println(dept2.getName());
		}
		model.addAttribute("deptList",list);
		return "dept/dept_select";
	}
	int pageSize=3;
	//动态查询
	@RequestMapping("main/selectDept2")
	public String countDept(Dept dept,Model model,Integer pageNow){
		Map params=new HashMap();
		if(pageNow==null) pageNow=1;
			params.put("dept",dept);
			params.put("pageSize",pageSize);
			params.put("pageNow",pageNow);
		int totalSize=deptService.countList();
		Pages page=new Pages(pageNow,pageSize,totalSize);
		System.out.println(pageNow+""+pageSize+""+totalSize);
		List<Dept> list=deptService.countDept(params);
		model.addAttribute("deptList",list);
		model.addAttribute("page",page);
		return "dept/dept_select";
	}
	//插入
	@RequestMapping("dept/insertDept")
	public String insertDept(Dept dept){
		deptService.insertDept(dept);
		return "redirect:../main/selectDept2";
	}
	//删除
	@RequestMapping("/deleteDept")
	public String deleteDept(int id){
		deptService.deleteById(id);
		return "redirect:main/selectDept2";
	}
	//修改 
	@RequestMapping("/updateDept")
	public String updateDept(Dept dept,Model model){
		//根据id查询用户 返回员工页面
		Dept target=deptService.selectById(dept.getId());
		model.addAttribute("dept",target);
		return "dept/dept_update";
	}
	@RequestMapping("/updateDeptView")
	public String updateDeptView(Dept dept){
		deptService.updateDept(dept);
		return "redirect:main/selectDept2";
	}
}
