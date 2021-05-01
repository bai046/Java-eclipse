package view;

import java.util.List;

import pojo.Student;
import manager.GradeManager;
import manager.StudentManager;
import tools.Tools;

public class GradeView {

	/**
	 * 增加一个成绩
	 */
	public static void add() {
		System.out.println("请输入要添加成绩的用户名：");
		String username = Tools.scanner.next();
		System.out.println("请输入课程的编号：");
		String code = Tools.scanner.next();
		System.out.println("请输入分数：");
		double result = Tools.getDouble(Tools.scanner.next(), 0);
		try {
			if (GradeManager.add(username, code, result)) {
				System.out.println("添加成功");
			} else {
				System.out.println("添加失败，您输入的信息错误");
			}

		} catch (Exception e) {
			System.out.println("添加失败，您输入的信息错误");
		}
	}

	/**
	 * 删除用户的成绩
	 */
	public static void del() {
		System.out.println("请输入要删除成绩的用户名：");
		String username = Tools.scanner.next();
		System.out.println("请输入课程的编号：");
		String code = Tools.scanner.next();
		try {
			GradeManager.del(username, code);
			System.out.println("删除成功");
		} catch (Exception e) {
			System.out.println("删除失败。您输入的信息错误");
		}
	}

	/**
	 * 修改用户的成绩
	 */
	public static void update() {
		System.out.println("请输入要修改成绩的用户名：");
		String username = Tools.scanner.next();
		System.out.println("请输入课程的编号：");
		String code = Tools.scanner.next();
		System.out.println("请输入新的分数：");
		double result = Tools.getDouble(Tools.scanner.next(), 0);
		try {
			if(GradeManager.update(username, code, result)){
				System.out.println("修改成功");
			}
			else{
				System.out.println("修改失败，可能成绩信息不存在");
			}
		} catch (Exception e) {
			System.out.println("修改失败，您输入的信息错误");
		}
	}

	/**
	 * 查询指定用户的成绩
	 */
	public static void find() {
		System.out.println("请输入要查询成绩的用户名：");
		String username = Tools.scanner.next();
		try {
			Student student = StudentManager.findByUserName(username);
			String[][] result = GradeManager.find(username);

			for (int i = 0; i < result.length; i++) {
				System.out.println("用户账户：" + student.getUsername() + "姓名：" + student.getName() + ":课程编号：" + result[i][0]
						+ "课程名称：" + result[i][1] + "成绩：" + result[i][2]);
			}

		} catch (Exception e) {
			System.out.println("查询失败，您输入的信息有误");
		}
	}

	/**
	 * 查询指定用户的成绩
	 */
	public static void find(String username) {
		try {
			Student student = StudentManager.findByUserName(username);
			String[][] result = GradeManager.find(username);

			for (int i = 0; i < result.length; i++) {
				System.out.println("用户账户：" + student.getUsername() + "姓名：" + student.getName() + ":课程编号：" + result[i][0]
						+ "课程名称：" + result[i][1] + "成绩：" + result[i][2]);
			}

		} catch (Exception e) {
			System.out.println("查询失败，您输入的信息有误");
		}
	}

	/**
	 * 查询所有用户的成绩
	 */
	public static void findAll() {
		List<Student> list = StudentManager.find();

		try {
			for (int i = 0; i < list.size(); i++) {
				Student student = list.get(i);
				String[][] result = GradeManager.find(student.getUsername());

				for (int j = 0; j < result.length; j++) {
					System.out.println("用户账户：" + student.getUsername() + "姓名：" + student.getName() + ":课程编号："
							+ result[j][0] + "课程名称：" + result[j][1] + "成绩：" + result[j][2]);
				}
			}

		} catch (Exception e) {
			System.out.println("查询失败");
		}

	}
}


