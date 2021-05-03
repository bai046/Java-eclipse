package manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import data.DataBase;
import pojo.Student;

/**
 * 学生的业务
 */
public class StudentManager {
	
	// 添加
	public static boolean add(Student student) {
		if(DataBase.getStudents().containsKey(student.getUsername())){
			return false;
		}
		else{
			DataBase.getStudents().put(student.getUsername(), student);
			return true;
		}
		
	}

	// 删除
	public static void del(String username) {
		DataBase.getStudents().remove(username);
	}

	// 改
	public static void update(Student student) {
		DataBase.getStudents().put(student.getUsername(), student);
	}

	// 查所有
	public static List<Student> find() {
		Map<String, Student> stus = DataBase.getStudents();
		Set<String> kSet = stus.keySet();
		Object[] objs = kSet.toArray();
		List<Student> list = new ArrayList<Student>();
		for (int i = 0; i < objs.length; i++) {
			String sid = (String) (objs[i]);
			list.add(stus.get(sid));
		}
		return list;
	}

	// 查一个
	public static Student findByUserName(String username) {
		return DataBase.getStudents().get(username);
	}

	// 登录
	public static boolean login(String username,String password){
		Student stu=DataBase.getStudents().get(username);
		try {
			if(password.equals(stu.getPassword())){
				//登录成功
				DataBase.getRequest().put("login", stu);
				return true;
			}
			else{
				//登录失败
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		
	}
}

