package data;

import java.util.HashMap;
import java.util.Map;

import pojo.Course;
import pojo.ManagerPerson;
import pojo.Student;


public class DataBase {
	private static Map<String,Object> request=new HashMap<>();//存储一些数据
	private static Map<String,Student> students=new HashMap<>();//学生的数据
	private static Map<String,ManagerPerson> managerPersons=new HashMap<>();//管理员的数据
	private static Map<String,Course> courses=new HashMap<>();//课程的数据
	public static Map<String, Student> getStudents() {
		return students;
	}
	public static void setStudents(Map<String, Student> students) {
		DataBase.students = students;
	}
	public static Map<String, ManagerPerson> getManagerPersons() {
		return managerPersons;
	}
	public static void setManagerPersons(Map<String, ManagerPerson> managerPersons) {
		DataBase.managerPersons = managerPersons;
	}
	public static Map<String, Course> getCourses() {
		return courses;
	}
	public static void setCourses(Map<String, Course> courses) {
		DataBase.courses = courses;
	}
	public static Map<String, Object> getRequest() {
		return request;
	}
	public static void setRequest(Map<String, Object> request) {
		DataBase.request = request;
	}}

