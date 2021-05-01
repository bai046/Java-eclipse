package view;

import java.util.List;

import pojo.Course;
import manager.CourseManager;
import tools.Tools;

public class CourseView {

	/**
	 * 添加一个课程
	 */
	public static void add() {
		// 请输入课程的编号
		System.out.println("请输入课程的编号：");
		Course course = new Course();
		course.setId(Tools.scanner.next());
		System.out.println("请输入课程的名字：");
		course.setName(Tools.scanner.next());

		if (CourseManager.add(course)) {
			System.out.println("添加成功");
		} else {
			System.out.println("添加失败，课程的编号可能已经存在");
		}

	}

	/**
	 * 修改课程的信息
	 */
	public static void update() {
		// 请输入课程的编号
		System.out.println("请输入课程的编号：");
		Course course = CourseManager.find(Tools.scanner.next());
		if (course == null) {
			System.out.println("输入的课程查不到，请查证后输入");
		} else {
			System.out.println("请输入新的课程的名字：");
			course.setName(Tools.scanner.next());
			System.out.println("修改成功");
		}
	}

	/**
	 * 查找所有课程的信息
	 */
	public static void find() {
		List<Course> list = CourseManager.find();
		for (Course course : list) {
			System.out.println(course);
		}
	}
	
	
	/**
	 * 查询指定的课程的信息
	 */
	public static Course findById(String id) {
		Course course = CourseManager.find(id);
		if (course == null) {
			System.out.println("输入的课程查不到，请查证后输入");
		} else {
			System.out.println(course);
		}
		return course;
	}

	/**
	 * 查询指定的课程的信息
	 */
	public static void findById() {
		// 请输入课程的编号
		System.out.println("请输入课程的编号：");
		Course course = CourseManager.find(Tools.scanner.next());
		if (course == null) {
			System.out.println("输入的课程查不到，请查证后输入");
		} else {
			System.out.println(course);
		}
	}
}


