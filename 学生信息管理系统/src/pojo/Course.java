package pojo;

public class Course {
	private String id;//课程的id
	private String name;//课程的名字
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return " [课程编号=" + id + ", 课程名=" + name + "]";
	}}


