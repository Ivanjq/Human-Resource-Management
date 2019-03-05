package com.hrm.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrm.domain.Dept;
import com.hrm.domain.Employee;
import com.hrm.domain.Job;
import com.hrm.domain.Salary;
import com.hrm.domain.Pages;
import com.hrm.domain.Salary;
import com.hrm.domain.User;
import com.hrm.service.DeptService;
import com.hrm.service.JobService;
import com.hrm.service.SalaryService;
import com.hrm.service.SalaryService;

/*处理用户请求控制器*/
@Controller
public class SalaryController {
	/*自动注入SalaryService*/
	@Autowired
	@Qualifier("salaryService")
	SalaryService salaryService;
	@Autowired
	@Qualifier("deptService")
	DeptService deptService;
	@Autowired
	@Qualifier("jobService")
	JobService jobService;
	//动态查询
	@RequestMapping("main/selectSalary")
	public String selectSalary(Integer job_id,Integer dept_id,Dept dept,Job job,Salary salary,Model model,Integer pageNow){
		this.genericAssciation(job_id, dept_id, salary);
		Map params=new HashMap();
		if(pageNow==null) pageNow=1;
			params.put("salary",salary);
			params.put("pageSize",pageSize);
			params.put("pageNow",pageNow);
		int totalSize=salaryService.countList();
		Pages page=new Pages(pageNow,pageSize,totalSize);
		System.out.println(pageNow+""+pageSize+""+totalSize);
		List<Salary> list=salaryService.countSalary(params);
		model.addAttribute("salaryList",list);
		List<Dept> list2=deptService.selectDept(dept);
		model.addAttribute("deptList",list2);
		List<Job> list3=jobService.selectJob(job);
		model.addAttribute("jobList",list3);
		model.addAttribute("page",page);
		System.out.println("selectSalary");
		return "salary/lookSalaryself";
	}
	int pageSize=3;
	//动态查询
	@RequestMapping("main/selectSalary2")
	public String countSalary(Integer job_id,Integer dept_id,Dept dept,Job job,Salary salary,Model model,Integer pageNow){
		this.genericAssciation(job_id, dept_id, salary);
		Map params=new HashMap();
		if(pageNow==null) pageNow=1;
			params.put("salary",salary);
			params.put("pageSize",pageSize);
			params.put("pageNow",pageNow);
		int totalSize=salaryService.countList();
		Pages page=new Pages(pageNow,pageSize,totalSize);
		System.out.println(pageNow+""+pageSize+""+totalSize);
		List<Salary> list=salaryService.countSalary(params);
		model.addAttribute("salaryList",list);
		List<Dept> list2=deptService.selectDept(dept);
		model.addAttribute("deptList",list2);
		List<Job> list3=jobService.selectJob(job);
		model.addAttribute("jobList",list3);
		model.addAttribute("page",page);
		System.out.println("selectSalary");
		return "salary/lookSalary";
	}
	//插入
	@RequestMapping("main/insertSalaryView")
	public String insertSalaryView(Integer job_id,Integer dept_id,Salary salary,Model model){
		this.genericAssciation(job_id, dept_id, salary);
		List<Salary> list=salaryService.selectSalary(salary);
		model.addAttribute("salaryList",list);
		List<Dept> list2=deptService.findAllDept();
		model.addAttribute("deptList",list2);
		List<Job> list3=jobService.findAllJob();
		model.addAttribute("jobList",list3);
		return "salary/addSalary";
	}
	@RequestMapping("salary/insertSalary")
	public String insertSalary(Integer job_id,Integer dept_id,Dept dept,Job job,Salary salary,Model model,User user){
		this.genericAssciation(job_id, dept_id, salary);
		System.out.println("123456789");
		salaryService.insertSalary(salary);
		System.out.println("123456");
		return "redirect:../main/selectSalary2";
	}
	//删除
	@RequestMapping("/deleteSalary")
	public String deleteSalary(int id){
		salaryService.deleteById(id);
		return "redirect:main/selectSalary2";
	}
	//修改 
	@RequestMapping("/updateSalary")
	public String updateSalary(Integer job_id,Integer dept_id,Dept dept,Job job,Salary salary,Model model){
		this.genericAssciation(job_id, dept_id, salary);
		List<Dept> list2=deptService.selectDept(dept);
		model.addAttribute("deptList",list2);
		List<Job> list3=jobService.selectJob(job);
		model.addAttribute("jobList",list3);
		//根据id查询 返回页面
		Salary target=salaryService.selectById(salary.getId());
		model.addAttribute("salary",target);
		return "salary/updateSalary";
	}
	@RequestMapping("/updateSalaryView")
	public String updateSalaryView(Salary salary,Integer job_id,Integer dept_id,Dept dept,Job job){
		this.genericAssciation(job_id, dept_id, salary);
		salaryService.updateSalary(salary);
		return "redirect:main/selectSalary2";
	}
	/*关联映射*/
	public void genericAssciation(Integer job_id,Integer dept_id,Salary salary){
		if(job_id!=null){
			Job job=new Job();
			job.setId(job_id);
			salary.setJob(job);
		}
		if(dept_id!=null){
			Dept dept=new Dept();
			dept.setId(dept_id);
			salary.setDept(dept);
		}
	}
}
