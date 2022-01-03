package com.edu.tutor.service;

import java.util.List;

import com.edu.tutor.entity.Menu;
import com.edu.tutor.pojo.Page;

public interface MenuService {

	List<Menu> queryMenuList(Page page);
	
	/**显示的菜单数据**/
	List menuList();

	/**
	 * 查询数据条数
	 * @return
	 */
	Integer countMenu();
}
