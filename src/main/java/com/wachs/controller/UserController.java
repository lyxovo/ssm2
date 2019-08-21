package com.wachs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.wachs.pojo.User;
import com.wachs.service.UserService;
/*出现这个错误:"Unknown character set: 'utf8mb4'] with root cause" 
可能是mysql数据驱动版本问题：使用版本5.1.39会出现，换5.1.6就行。*/

@Controller
public class UserController {
	@Autowired
	private UserService userservice;
	
	@RequestMapping("/index.do")
	public Object index(@RequestParam(value="pageNum",defaultValue="1") Integer pageNum,
			@RequestParam(value="pageSize",defaultValue="3")Integer pageSize,Model model) {
		PageInfo<User>pageInfo=userservice.queryUsers(pageNum,pageSize);
		model.addAttribute("pageInfo", pageInfo);
		System.out.println(pageInfo.getList());
		return "index";
	}
}
