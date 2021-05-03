package manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import data.DataBase;
import pojo.Course;

/**
 * 课程的业务处理
 *
 */
public class CourseManager {

	//增
	public static boolean add(Course course){
		if(DataBase.getCourses().containsKey(course.getId())){
			return false;
		}
		else{
			DataBase.getCourses().put(course.getId(), course);
			return true;
		}
		
	}
	

	
	//改
	public static void update(Course course){
		DataBase.getCourses().put(course.getId(), course);
	}
	
	//查
	public static List<Course> find(){
		Map<String, Course> stus = DataBase.getCourses();
		Set<String> kSet = stus.keySet();
		Object[] objs = kSet.toArray();
		List<Course> list = new ArrayList<Course>();
		for (int i = 0; i < objs.length; i++) {
			String sid = (String) (objs[i]);
			list.add(stus.get(sid));
		}
		return list;
	}
	
	/**
	 * 返回课程的信息
	 * @param id 课程的id
	 * @return 返回的课程的信息，如果输入的课程的id没有查到，返回空
	 */
	public static Course find(String id){
		return DataBase.getCourses().get(id);
	}
}

