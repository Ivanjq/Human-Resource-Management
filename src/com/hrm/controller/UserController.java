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

import com.hrm.domain.Pages;
import com.hrm.domain.User;
import com.hrm.service.UserService;
/*处理用户请求控制器*/
@Controller
public class UserController {
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	/*自动注入userService*/
	@Autowired
	@Qualifier("userService")
	//@Resource("userService")
	UserService userService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(User user,HttpSession session,Model model){
//		User user2=userService.login(user.getLoginname(),user.getPassword());
		User user2=userService.login(user);
		if(user2.getLoginname().equals("admin")){
			session.setAttribute("user",user2);
			System.out.println("HrmController success-->>");
			return "main/admin_main";
		}else if(user2!=null){
			session.setAttribute("user",user2);
			System.out.println("HrmController success-->>");
			return "main/main";
		}else{
			model.addAttribute("msg","信息输入错误！");
			System.out.println("HrmController fail-->>");
			return "login";
		}
	}
	//动态查询
	@RequestMapping("main/selectUser")
	public String selectUser(User user,Model model){
//		User list=userService.findUserById(user.getId());
//		model.addAttribute("userList",list);
		return "user/user_selectself";
	}

	int pageSize=3;
	//动态查询
	@RequestMapping("main/selectUser2")
	public String countUser(User user,Model model,Integer pageNow){
		Map params=new HashMap();
		if(pageNow==null) pageNow=1;
			params.put("user",user);
			params.put("pageSize",pageSize);
			params.put("pageNow",pageNow);
		int totalSize=userService.countList();
		Pages page=new Pages(pageNow,pageSize,totalSize);
		System.out.println(pageNow+""+pageSize+""+totalSize);
		List<User> list=userService.countUser(params);
		model.addAttribute("userList",list);
		model.addAttribute("page",page);
		return "user/user_select";
	}
	
	//插入
	@RequestMapping("user/insertUser")
	public String insertUser(User user){
		Date createdate=new Date();
		user.setCreatedate(createdate);
		userService.insertUser(user);
		return "redirect:../main/selectUser2";
	}
	//删除
	@RequestMapping("/deleteUser")
	public String deleteUser(int id){
		userService.deleteById(id);
		return "redirect:main/selectUser2";
	}
	//修改
	@RequestMapping("/updateUser")
	public String updateUser(User user,Model model){
		//根据id查询用户 返回员工页面
		User target=userService.findUserById(user.getId());
		model.addAttribute("user",target);
		return "user/user_update";
	}
	@RequestMapping("main/updateUserView")
	public String updateUserView(User user){
		Date createdate=new Date();
		user.setCreatedate(createdate);
		userService.updateUser(user);
		return "redirect:selectUser2";
	}
	@RequestMapping("/updateUser1")
	public String updateUser1(User user,Model model){
		//根据id查询用户 返回员工页面
		User target=userService.findUserById(user.getId());
		model.addAttribute("user",target);
		return "user/user_updateself";
	}
	@RequestMapping("main/updateUserView1")
	public String updateUserView1(User user){
		Date createdate=new Date();
		user.setCreatedate(createdate);
		userService.updateUser(user);
		return "redirect:selectUser";
	}
}
