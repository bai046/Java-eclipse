package tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import data.DataBase;
import pojo.Course;
import pojo.ManagerPerson;
import pojo.Student;
import view.CourseView;
public class Stulint {
public static void start() {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		File file = new File(Stulint.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "StuManagerConfig.ini");

		if (file.exists()) {
			// 配置文件存在，读取
			System.out.println("正在读取数据...");
			String courseStr = "";
			String managerPersonStr = "";
			String studentsStr = "";
			try {
				fileReader = new FileReader(file);
				bufferedReader = new BufferedReader(fileReader);
				courseStr = bufferedReader.readLine();// 课程信息的读取
				managerPersonStr = bufferedReader.readLine();// 管理信息的读取
				studentsStr = bufferedReader.readLine();// 用户信息的读取

			} catch (Exception e) {
				System.out.println("数据被破坏，不能读取，请删除数据重试");
			} finally {
				try {
					bufferedReader.close();
					fileReader.close();
				} catch (IOException e) {
					System.out.println("数据读取异常，数据可能已经被破坏");
					e.printStackTrace();
				}

			}


			// 初始化课程
			setCourses(courseStr);

			// 初始化管理员
			setManagerPersons(managerPersonStr);

			// 初始化用户
			setStudents(studentsStr);

		} else {
			// 不存在，初始化管理员
			ManagerPerson person = new ManagerPerson();
			person.setUsername("admin");
			person.setPassword("admin");
			person.setName("老李");
			person.setCreateDate(new Date());
			person.setSex(1);
			person.setAge(20);
			person.setRank(0);
			person.setAddress("陕西省");
			DataBase.getManagerPersons().put(person.getUsername(), person);
		}
	}

	/**
	 * 程序结束的时候保存数据
	 */
	public static void stop() {
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		File file = new File(Stulint.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "StuManagerConfig.ini");

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("配置文件保存失败");
				e.printStackTrace();
			}
		}

		try {
			fileWriter = new FileWriter(file);
			bufferedWriter = new BufferedWriter(fileWriter);

			// 写入课程的信息
			bufferedWriter.write(getCourses());
			bufferedWriter.newLine();

			// 写入管理员的信息
			bufferedWriter.write(getManagerPersons());
			bufferedWriter.newLine();

			// 写入学生的信息
			bufferedWriter.write(getStudents());

		} catch (IOException e) {
			System.out.println("数据保存失败，可能出现异常");
			e.printStackTrace();
		} finally {
			try {
				bufferedWriter.close();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("数据保存出现异常，数据可能损坏");
				e.printStackTrace();
			}

		}

	}

	/**
	 * 组织课程的信息
	 * 
	 * @return
	 */
	public static String getCourses() {
		String string = "{";
		Set<String> set = DataBase.getCourses().keySet();

		Object[] objects = set.toArray();
		for (int i = 0; i < objects.length; i++) {
			String id = (String) objects[i];
			Course course = DataBase.getCourses().get(id);
			string = string + "<" + course.getId() + ":" + course.getName() + ">";
			if (i != objects.length - 1) {
				string += "╋";
			}
		}
		string += "}";
		return string;
	}
	
	/**
	 * 初始化学生的信息
	 * @param string
	 */
	public static void setStudents(String string){

		//去掉两边的{}
		string = string.substring(1, string.length() - 1);
		if (string.length() != 0) {
			
			// 分别取出每个学生
			String[] strings = string.split("╋");

			// 创建每个学生
			for (int i = 0; i < strings.length; i++) {

				// 取出一个学生
				String oneStudent = strings[i];


				// 去掉学生的<>
				oneStudent = oneStudent.substring(1, oneStudent.length() - 1);


				// 分割信息
				String[] oneStudentSplit = oneStudent.split(",");

				// 新建一个课程
				Student student = new Student();

				//设置账户
				student.setUsername(oneStudentSplit[0]);
				student.setPassword(oneStudentSplit[1]);
				student.setName(oneStudentSplit[2]);
				student.setSex(Tools.getInteger(oneStudentSplit[3], 1));
				student.setAge(Tools.getInteger(oneStudentSplit[4], 0));
				student.setCreateDate(Tools.getDate(oneStudentSplit[5]));
				student.setAddress(oneStudentSplit[6]);
				
				
				//学生的成绩
				if(oneStudentSplit.length>7){
					//有成绩的信息
					String resultStr=oneStudentSplit[7];
					
					//分割成绩
					
					String[] results=resultStr.split("\\|");
					
					for(int j=0;j<results.length;j++){
						//有几个成绩
						
						String[] oneResult=results[j].split(":");
						//根据编号查课程
						Course course=CourseView.findById(oneResult[0]);
						student.getResults().put(course, Tools.getDouble(oneResult[1], 0));
					}
				}
				
				

				// 存储
				DataBase.getStudents().put(student.getUsername(), student);
				
			

			}
		} else {
			// 无学生信息
			System.out.println("没有学生信息，跳过...");
		}
	}
	
	/**
	 * 初始化管理员的信息
	 * @param string
	 */
	public static void setManagerPersons(String string){

		//去掉两边的{}
		string = string.substring(1, string.length() - 1);
		if (string.length() != 0) {
			
			// 分别取出每个管理员
			String[] strings = string.split("╋");

			// 创建每个管理员
			for (int i = 0; i < strings.length; i++) {

				// 取出一个管理员
				String oneManagerPerson = strings[i];


				// 去掉管理员的<>
				oneManagerPerson = oneManagerPerson.substring(1, oneManagerPerson.length() - 1);


				// 分割id和名字
				String[] oneManagerPersonSplit = oneManagerPerson.split(",");

				// 新建一个课程
				ManagerPerson managerPerson = new ManagerPerson();

				//设置账户
				managerPerson.setUsername(oneManagerPersonSplit[0]);
				managerPerson.setPassword(oneManagerPersonSplit[1]);
				managerPerson.setName(oneManagerPersonSplit[2]);
				managerPerson.setSex(Tools.getInteger(oneManagerPersonSplit[3], 1));
				managerPerson.setAge(Tools.getInteger(oneManagerPersonSplit[4], 0));
				managerPerson.setCreateDate(Tools.getDate(oneManagerPersonSplit[5]));
				managerPerson.setAddress(oneManagerPersonSplit[6]);
				managerPerson.setRank(Tools.getInteger(oneManagerPersonSplit[7], 1));
				
				

				// 存储
				DataBase.getManagerPersons().put(managerPerson.getUsername(), managerPerson);
				
				

			}
		} else {
			// 无管理员信息
			System.out.println("没有管理员信息，跳过...");
		}
	}

	/**
	 * 初始化课程的信息
	 * 
	 * @param
	 */
	public static void setCourses(String string) {
		
		//去掉两边的{}
		string = string.substring(1, string.length() - 1);
		if (string.length() != 0) {
			

			
			// 分别取出每个课程
			String[] strings = string.split("╋");

			// 创建每个课程
			for (int i = 0; i < strings.length; i++) {

				// 取出一个课程
				String oneCourse = strings[i];


				// 去掉课程的<>
				oneCourse = oneCourse.substring(1, oneCourse.length() - 1);


				// 分割id和名字
				String[] onCourseSplit = oneCourse.split(":");

				// 新建一个课程
				Course course = new Course();

				// 设置id
				course.setId(onCourseSplit[0]);

				// 设置名称
				course.setName(onCourseSplit[1]);

				// 存储
				DataBase.getCourses().put(course.getId(), course);

			}
		} else {
			// 无课程信息
			System.out.println("没有课程信息，跳过...");
		}
	}

	/**
	 * 组织管理员的信息
	 * 
	 * @return
	 */
	public static String getManagerPersons() {
		String string = "{";
		Set<String> set = DataBase.getManagerPersons().keySet();
		Object[] objects = set.toArray();

		for (int i = 0; i < objects.length; i++) {
			String id = (String) objects[i];
			ManagerPerson managerPerson = DataBase.getManagerPersons().get(id);
			string = string + "<" + managerPerson.getUsername() + "," + managerPerson.getPassword() + ","
					+ managerPerson.getName() + "," + managerPerson.getSex() + "," + managerPerson.getAge() + ","
					+ managerPerson.getCreateDate() + "," + managerPerson.getAddress() + "," + managerPerson.getRank()
					+ ">";
			if (i != objects.length - 1) {
				string += "╋";
			}
		}
		string += "}";
		return string;

	}

	/**
	 * 组织学生的信息
	 * 
	 * @return
	 */
	public static String getStudents() {
		String string = "{";

		Set<String> set = DataBase.getStudents().keySet();
		Object[] objects = set.toArray();

		for (int i = 0; i < objects.length; i++) {
			String id = (String) objects[i];
			Student student = DataBase.getStudents().get(id);
			string = string + "<" + student.getUsername() + "," + student.getPassword() + "," + student.getName() + ","
					+ student.getSex() + "," + student.getAge() + "," + student.getCreateDate() + ","
					+ student.getAddress();

			// 学生的成绩
			Map<Course, Double> map = student.getResults();

			if (!map.isEmpty()) {
				// 不是空的
				string += ",";
				Set<Course> courses = map.keySet();
				Object[] objs = courses.toArray();
				for (int j = 0; j < objs.length; j++) {
					Course course = (Course) objs[j];
					string += course.getId() + ":" + map.get(course);
					if (j != objs.length - 1) {
						string += "|";
					}
				}
			}
			string += ">";

			if (i != objects.length - 1) {
				string += "╋";
			}
		}

		string += "}";
		return string;
	}

}


