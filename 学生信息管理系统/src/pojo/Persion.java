package pojo;

import java.util.Date;

import tools.Tools;

public class Persion {
	protected String username;//用户的账户和id
	protected String password;//用户的密码
	protected String name;//用户的姓名
	protected int sex;//用户的性别0女，1男，2不详
	protected int age;//年龄
	protected Date createDate;//用户添加的时间
	protected String address;//用户的地址
	
	public Persion() {
		super();
	}
	public Persion(String username, String password, String name, int sex, int age, Date createDate, String address) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.createDate = createDate;
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCreateDate() {
		return Tools.format.format(createDate);
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "[用户名=" + username + ",  姓名=" + name + ", 性别=" + Tools.getSex(sex) + ", 年龄="
				+ age + ", 创建时间=" + Tools.format.format(createDate) + ", 地址=" + address + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persion other = (Persion) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
}


