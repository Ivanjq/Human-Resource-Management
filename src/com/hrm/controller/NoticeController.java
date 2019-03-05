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
import com.hrm.domain.Notice;
import com.hrm.domain.Pages;
import com.hrm.domain.User;
import com.hrm.service.NoticeService;

/*处理用户请求控制器*/
@Controller
public class NoticeController {
	/*自动注入NoticeService*/
	@Autowired
	@Qualifier("noticeService")
	//@Resource("NoticeService")
	NoticeService noticeService;
	//动态查询
	@RequestMapping("main/selectNotice")
	public String countNotice(Notice notice,Model model,Integer pageNow){
		Map params=new HashMap();
		if(pageNow==null) pageNow=1;
			params.put("notice",notice);
			params.put("pageSize",pageSize);
			params.put("pageNow",pageNow);
		int totalSize=noticeService.countList();
		Pages page=new Pages(pageNow,pageSize,totalSize);
		System.out.println(pageNow+""+pageSize+""+totalSize);
		List<Notice> list=noticeService.countNotice(params);
		model.addAttribute("noticeList",list);
		model.addAttribute("page",page);
		return "notice/notice_selectself";
	}
	int pageSize=3;
	//动态查询
	@RequestMapping("main/selectNotice2")
	public String countNotice2(Notice notice,Model model,Integer pageNow){
		Map params=new HashMap();
		if(pageNow==null) pageNow=1;
			params.put("notice",notice);
			params.put("pageSize",pageSize);
			params.put("pageNow",pageNow);
		int totalSize=noticeService.countList();
		Pages page=new Pages(pageNow,pageSize,totalSize);
		System.out.println(pageNow+""+pageSize+""+totalSize);
		List<Notice> list=noticeService.countNotice(params);
		model.addAttribute("noticeList",list);
		model.addAttribute("page",page);
		return "notice/notice_select";
	}
	//插入
	@RequestMapping("notice/insertNotice")
	public String insertNotice(Notice notice,User user){
		notice.setUser(user);
		noticeService.insertNotice(notice);
		return "redirect:../main/selectNotice2";
	}
	//删除
	@RequestMapping("/deleteNotice")
	public String deleteNotice(int id){
		noticeService.deleteById(id);
		return "redirect:main/selectNotice2";
	}
	//修改 
	@RequestMapping("/updateNotice")
	public String updateNotice(Notice notice,Model model){
		//根据id查询 返回页面
		Notice target=noticeService.selectById(notice.getId());
		model.addAttribute("notice",target);
		return "notice/notice_update";
	}
	@RequestMapping("/updateNoticeView")
	public String updateNoticeView(Notice notice){
		noticeService.updateNotice(notice);
		return "redirect:main/selectNotice2";
	}
}
