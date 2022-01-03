package com.edu.tutor.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.edu.tutor.entity.Menu;
import com.edu.tutor.pojo.Page;

@Mapper
public interface MenuDao {
	List<Menu> queryMenuList(@Param("page")Page page);

	Integer count();

	List<Menu> getMenus();
	
}
