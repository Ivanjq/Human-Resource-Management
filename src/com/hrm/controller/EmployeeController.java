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

import com.hrm.domain.Dept;
import com.hrm.domain.Employee;
import com.hrm.domain.Job;
import com.hrm.domain.Pages;
import com.hrm.domain.User;
import com.hrm.service.DeptService;
import com.hrm.service.EmployeeService;
import com.hrm.service.JobService;

/*处理用户请求控制器*/
@Controller
public class EmployeeController {
	/*自动注入EmployeeService*/
	@Autowired
	@Qualifier("employeeService")
	//@Resource("EmployeeService")
	EmployeeService employeeService;
	@Autowired
	@Qualifier("deptService")
	DeptService deptService;
	@Autowired
	@Qualifier("jobService")
	JobService jobService;
//	@RequestMapping("main/selectEmployee")
//	public String selectEmployee(Employee employee,User user,HttpSession session,Dept dept,Job job,
//			Integer job_id,Integer dept_id,Model model){
//		this.genericAssciation(job_id, dept_id, employee);
//		Employee list=employeeService.selectById();
//		model.addAttribute("employeeList",list);
//		List<Dept> list2=deptService.selectDept(dept);
//		model.addAttribute("deptList",list2);
//		List<Job> list3=jobService.selectJob(job);
//		model.addAttribute("jobList",list3);
//		return "employee/employee_select";
//	}
	int pageSize=3;
	//动态查询
	@RequestMapping("main/selectEmployee2")
	public String countEmployee(Employee employee,Dept dept,Job job,
			Integer job_id,Integer dept_id,Model model,Integer pageNow){
		Map params=new HashMap();
		if(pageNow==null) pageNow=1;
			params.put("employee",employee);
			params.put("pageSize",pageSize);
			params.put("pageNow",pageNow);
		int totalSize=employeeService.countList();
		Pages page=new Pages(pageNow,pageSize,totalSize);
		System.out.println(pageNow+""+pageSize+""+totalSize);
		this.genericAssciation(job_id, dept_id, employee);
		List<Employee> list=employeeService.countEmployee(params);
		model.addAttribute("employeeList",list);
		List<Dept> list2=deptService.selectDept(dept);
		model.addAttribute("deptList",list2);
		List<Job> list3=jobService.selectJob(job);
		model.addAttribute("jobList",list3);
		
		model.addAttribute("page",page);
		return "employee/employee_select";
	}
	//插入
	@RequestMapping("main/insertEmployeeView")
	public String insertEmployeeView(Integer job_id,Integer dept_id,Employee employee,Model model){
		this.genericAssciation(job_id, dept_id, employee);
		List<Employee> list=employeeService.selectEmployee(employee);
		model.addAttribute("employeeList",list);
		List<Dept> list2=deptService.findAllDept();
		model.addAttribute("deptList",list2);
		List<Job> list3=jobService.findAllJob();
		model.addAttribute("jobList",list3);
		return "employee/employee_add";
	}
	@RequestMapping("employee/insertEmployee")
	public String insertEmployee(Integer job_id,Integer dept_id,Employee employee){
		this.genericAssciation(job_id, dept_id, employee);
		Date createdate=new Date();
		employee.setCreateDate(createdate);
		employeeService.insertEmployee(employee);
		return "redirect:../main/selectEmployee2";
	}
	//删除
	@RequestMapping("/deleteEmployee")
	public String deleteEmployee(int id){
		employeeService.deleteById(id);
		return "redirect:main/selectEmployee2";
	}
	//修改 
	@RequestMapping("/updateEmployee")
	public String updateEmployee(Integer job_id,Integer dept_id,Dept dept,Job job,Employee employee,Model model){
		this.genericAssciation(job_id, dept_id, employee);
		Date birthday=employee.getBirthday();
		employee.setBirthday(birthday);
		List<Dept> list2=deptService.selectDept(dept);
		model.addAttribute("deptList",list2);
		List<Job> list3=jobService.selectJob(job);
		model.addAttribute("jobList",list3);
		//根据id查询用户 返回员工页面
		Employee target=employeeService.selectById(employee.getId());
		model.addAttribute("employee",target);
		return "employee/employee_update";
	}
	@RequestMapping("/updateEmployeeView")
	public String updateEmployeeView(Integer job_id,Integer dept_id,Dept dept,Job job,Employee employee){
		this.genericAssciation(job_id, dept_id, employee);
		Date birthday=employee.getBirthday();
		employee.setBirthday(birthday);
		employeeService.updateEmployee(employee);
		return "redirect:main/selectEmployee2";
	}
	/*关联映射*/
	public void genericAssciation(Integer job_id,Integer dept_id,Employee employee){
		if(job_id!=null){
			Job job=new Job();
			job.setId(job_id);
			employee.setJob(job);
		}
		if(dept_id!=null){
			Dept dept=new Dept();
			dept.setId(dept_id);
			employee.setDept(dept);
		}
	}
}
