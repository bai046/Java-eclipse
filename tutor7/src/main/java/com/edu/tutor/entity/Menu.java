package com.edu.tutor.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

public class Menu implements Comparable<Menu> {
	public interface ForList {}
	
	@JsonView(ForList.class)
	private String id;
	
	@JsonView(ForList.class)
	private String text;
	
	@JsonView(ForList.class)
	private Integer level;
	
	@JsonView(ForList.class)
	private String parent;
	
	private List<Menu> child;
	
	@JsonView(ForList.class)
	private Integer sequence;
	
	@JsonView(ForList.class)
	private String address;	//url地址
	
	@JsonView(ForList.class)
	private String platform;
	
	@JsonView(ForList.class)
	private String iconCls;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public List<Menu> getChild() {
		return child;
	}

	public void setChild(List<Menu> child) {
		this.child = child;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	/**
	 * 按照菜单层级和上级菜单顺序、本级菜单顺序的方式排列
	 */
	@Override
	public int compareTo(Menu o) {
		int result = 0;
		if((result = this.level.compareTo(o.level)) != 0){
			return result;
		}
		if(this.parent!=null && o.parent!=null 
				&& (result = this.parent.compareTo(o.parent)) != 0) {
			return result;
		}
		if((result = this.sequence.compareTo(o.sequence)) != 0) {
			return result;
		}
		
		
		return this.id.compareTo(o.id);
	}
	
}
