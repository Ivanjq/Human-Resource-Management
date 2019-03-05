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

/*�����û����������*/
@Controller
public class DeptController {
	/*�Զ�ע��DeptService*/
	@Autowired
	@Qualifier("deptService")
	//@Resource("DeptService")
	DeptService deptService;
	//��̬��ѯ
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
	//��̬��ѯ
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
	//����
	@RequestMapping("dept/insertDept")
	public String insertDept(Dept dept){
		deptService.insertDept(dept);
		return "redirect:../main/selectDept2";
	}
	//ɾ��
	@RequestMapping("/deleteDept")
	public String deleteDept(int id){
		deptService.deleteById(id);
		return "redirect:main/selectDept2";
	}
	//�޸� 
	@RequestMapping("/updateDept")
	public String updateDept(Dept dept,Model model){
		//����id��ѯ�û� ����Ա��ҳ��
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
