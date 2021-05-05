package manager;

import java.util.Map;
import java.util.Set;

import data.DataBase;
import pojo.Course;

/**
 * 成绩的业务
 * 
 */
public class GradeManager {
	/**
	 * 增加成绩
	 * 
	 * @param username
	 *            用户名
	 * @param courseId
	 *            课程的id
	 * @param result
	 *            分数
	 */
	public static boolean add(String username, String courseId, double result) {

		try {
			Course course = DataBase.getCourses().get(courseId);
			if (course != null) {
				if (DataBase.getStudents().get(username).getResults().containsKey(course)) {
					return false;
				} else {
					DataBase.getStudents().get(username).getResults().put(course, result);
					return true;
				}

			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * 删除学生的成绩
	 * 
	 * @param username
	 *            用户名
	 * @param courseId
	 *            课程的id
	 */
	public static void del(String username, String courseId) {
		Course course = DataBase.getCourses().get(courseId);
		DataBase.getStudents().get(username).getResults().remove(course);
	}

	/**
	 * 修改用户的成绩
	 * 
	 * @param username
	 *            用户名
	 * @param courseId
	 *            课程的id
	 * @param result
	 *            成绩分数
	 */
	public static boolean update(String username, String courseId, double result) {
		Course course = DataBase.getCourses().get(courseId);
		if(DataBase.getStudents().get("username").getResults().containsKey(course)){
			DataBase.getStudents().get(username).getResults().put(course, result);
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * 查,显示课程的id和课程的名字，和成绩
	 * 
	 * @param username
	 *            查询的用户的用户名
	 */
	public static String[][] find(String username) {
		Map<Course, Double> stus = DataBase.getStudents().get(username).getResults();
		Set<Course> kSet = stus.keySet();
		Object[] objs = kSet.toArray();
		Course[] courses = new Course[objs.length];
		for (int i = 0; i < objs.length; i++) {
			courses[i] = (Course) objs[i];
		}
		String[][] result = new String[objs.length][3];
		for (int i = 0; i < objs.length; i++) {

			result[i][0] = courses[i].getId();
			result[i][1] = courses[i].getName();
			result[i][2] = stus.get(courses[i]) + "";
		}
		return result;
	}
}


