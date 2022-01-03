package com.edu.tutor.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edu.tutor.entity.Menu;
import com.edu.tutor.service.MenuService;

@Controller
public class UserLoginConctoller {
	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value="/login")
	public String login(){
		
		return "redirect:index.html";
	}
	
//	@RequestMapping(method = RequestMethod.GET, value="/login.html")
//	public String loginPage(){
//		
//		return "login.html";
//	}
	
	@RequestMapping(value="/index.html")
	public String index(Model model){
		List<Map> menuList = menuService.menuList();
//		List menuList = new ArrayList<Menu>();
//		Menu menu = new Menu();
//		menu.setId("m1001");
//		menu.setText("系统管理");
//		menu.setIconCls("fa fa-wpforms");
//		menuList.add(menu);
		
		model.addAttribute("menu", menuList);
		return "index.html";
	}
	
}
