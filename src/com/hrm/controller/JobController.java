package com.hrm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrm.domain.Dept;
import com.hrm.domain.Job;
import com.hrm.domain.Pages;
import com.hrm.service.JobService;

/*�����û����������*/
@Controller
public class JobController {
	/*�Զ�ע��JobService*/
	@Autowired
	@Qualifier("jobService")
	//@Resource("JobService")
	JobService jobService;
	
	@RequestMapping("main/selectJob")
	public String selectJob(Job job,Model model){
		List<Job> list=jobService.selectJob(job);
		for(Job job2:list){
			System.out.println(job2.getName());
		}
		model.addAttribute("jobList",list);
		return "job/job_select";
	}
	int pageSize=3;
	//��̬��ѯ
	@RequestMapping("main/selectJob2")
	public String countJob(Job job,Model model,Integer pageNow){
		Map params=new HashMap();
		if(pageNow==null) pageNow=1;
			params.put("job",job);
			params.put("pageSize",pageSize);
			params.put("pageNow",pageNow);
		int totalSize=jobService.countList();
		Pages page=new Pages(pageNow,pageSize,totalSize);
		System.out.println(pageNow+""+pageSize+""+totalSize);
		List<Job> list=jobService.countJob(params);
		model.addAttribute("jobList",list);
		model.addAttribute("page",page);
		return "job/job_select";
	}
	//����
	@RequestMapping("job/insertJob")
	public String insertJob(Job job){
		jobService.insertJob(job);
		return "redirect:../main/selectJob2";
	}
	//ɾ��
	@RequestMapping("/deleteJob")
	public String deleteJob(int id){
		jobService.deleteById(id);
		return "redirect:main/selectJob2";
	}
	//�޸� 
	@RequestMapping("/updateJob")
	public String updateJob(Job job,Model model){
		//����id��ѯ�û� ����Ա��ҳ��
		Job target=jobService.selectById(job.getId());
		model.addAttribute("job",target);
		return "job/job_update";
	}
	@RequestMapping("/updateJobView")
	public String updateJobView(Job job){
		jobService.updateJob(job);
		return "redirect:main/selectJob2";
	}
}
