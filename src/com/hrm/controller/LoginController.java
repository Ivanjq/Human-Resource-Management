package com.hrm.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	//À¹½ØÌø×ª
	@RequestMapping(value="{pathname1}/{pathname2}")
	public String aa(@PathVariable String pathname1,@PathVariable String pathname2){
		System.out.println("LoginController  "+pathname1+" / "+pathname2);
		return pathname1+"/"+pathname2;
	}
	@RequestMapping(value="{pathname}")
	public String bb(@PathVariable String pathname){
		System.out.println("LoginController    "+pathname);
		return pathname;
	}
}
