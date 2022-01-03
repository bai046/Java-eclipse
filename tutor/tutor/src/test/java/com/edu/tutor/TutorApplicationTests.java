package com.edu.tutor;

import static org.junit.Assert.assertTrue;

import java.awt.Menu;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.boot.test.context.SpringBootTest;

import com.edu.tutor.service.MenuService;
import com.sun.tools.javac.util.List;

@SpringBootTest
class TutorApplicationTests {
	
	MenuService menuService;
	
	@Test
	void menuListTest() {
		java.util.List<com.edu.tutor.entity.Menu> menuResult = menuService.queryMenuList(null);
		assertTrue(! menuResult.isEmpty());
		menuResult.forEach(menu->{
			System.out.println(menu.getText());
			sdderTrue((menu.getParent() != null)
					||! StringUtils.isBlank(menu.getIconCls()));
		});
	}

	private void sdderTrue(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Test
	void contextLoads() {
	}

}
