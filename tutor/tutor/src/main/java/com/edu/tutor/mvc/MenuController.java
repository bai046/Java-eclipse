package com.edu.tutor.mvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.xml.ws.RespectBinding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.edu.tutor.entity.Menu;
import com.edu.tutor.pojo.Page;
import com.edu.tutor.service.MenuService;
import com.fasterxml.jackson.annotation.JsonView;

@Controller
@RequestMapping(value="/menu")
public class MenuController {
	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value="/list.html")
	public String showMenu(Model model){
		Integer counts = menuService.countMenu();
		model.addAttribute("counts", counts);
		
		return "menu/list.html";
	}
	
	@RequestMapping(value="/list")
	@ResponseBody
	@JsonView(Menu.ForList.class)
	public List list(Page page){
		List<Menu> menuList = menuService.queryMenuList(page);
		Collections.sort(menuList);
		
		return menuList;
	}
}
