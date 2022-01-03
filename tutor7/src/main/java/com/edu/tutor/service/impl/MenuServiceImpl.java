package com.edu.tutor.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.edu.tutor.dao.MenuDao;
import com.edu.tutor.entity.Menu;
import com.edu.tutor.pojo.Page;
import com.edu.tutor.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {
	@Resource
	MenuDao menuDao;

	@Override
	public List<Menu> queryMenuList(Page page) {
		if(page == null) {
			page = new Page();
		}
		
		page.setBegin((page.getCurrentPage()-1)*page.getPageSize());
		page.setEnd(page.getCurrentPage()*page.getPageSize()-1);
		
		return menuDao.queryMenuList(page);
	}
	
	public List<Menu> getMenus() {
		return menuDao.getMenus();
	}

	public List menuList(){
		List<Menu> menuList = getMenus();
		Collections.sort(menuList);
		Map<String, Map<String, Object>> menuMap = new HashMap<String, Map<String, Object>>();
		List<Map<String, Object>> mapList = menuList.stream().map(menu->{
			Map<String, Object> newMenu = new HashMap<>();
			if(menu.getLevel() == 1) {
				newMenu.put("text", menu.getText());
				newMenu.put("iconCls", menu.getIconCls());
				newMenu.put("level", 1);
			} else {
				Map<String, Object> parent = menuMap.get(menu.getParent());
				if(parent.get("children") == null) {
					parent.put("children", new ArrayList());
				}
				newMenu.put("text", "<input type='hidden' value='" + menu.getAddress() + "'/>" + menu.getText());
				((List<Map<String, Object>>) parent.get("children")).add(newMenu);
			}
			menuMap.put(menu.getId(), newMenu);
			
			return newMenu;
		}).filter(menu->{
			if(menu.get("level") != null) {
				menu.remove("level");
				return true;
			}
			return false;
		}).collect(Collectors.toList());
		
		return mapList;
	}

	@Override
	public Integer countMenu() {
		
		return menuDao.count();
	}
}
