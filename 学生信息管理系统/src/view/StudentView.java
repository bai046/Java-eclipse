package view;

import java.util.Date;
import java.util.List;

import data.DataBase;
import pojo.Student;
import manager.StudentManager;
import tools.Tools;

/**
 * 学生的交互界面
*/
public class StudentView {
/**
	 * 用户登录
	 * @return
	 */
	public static boolean login(){
		System.out.println("请输入学生的账户：");
		String username=Tools.scanner.next();
		System.out.println("请输入学生的密码：");
		String password=Tools.scanner.next();
		//判断是否登录成功，如果成功将登录用户的信息存放到request login中
		return StudentManager.login(username, password);
	}
	/**
	 * 增加一个学生
	 */
	public static void add() {
		// 新建一个学生的对象
		Student student = new Student();
		// 添加创建用户的时间
		student.setCreateDate(new Date());
		System.out.println("请输入用户的账户：");
		student.setUsername(Tools.scanner.next());
		System.out.println("请输入用户的密码：");
		student.setPassword(Tools.scanner.next());
		System.out.println("请输入用户的姓名：");
		student.setName(Tools.scanner.next());
		System.out.println("请选择用户的性别：");
		System.out.println("0：女；  1：男；  2：不详");

		// 输入用户的性别，并进行数据的校验
		int sex = Math.abs(Tools.getInteger(Tools.scanner.next(), 2));
		student.setSex(sex > 2 ? 2 : sex);

		System.out.println("请输入用户年龄：");
		student.setAge(Tools.getInteger(Tools.scanner.next(), 0));
		student.setCreateDate(new Date());// 添加用户的时间
		System.out.println("请输入用户的地址：");
		student.setAddress(Tools.scanner.next());

		if(StudentManager.add(student)){
			System.out.println("添加成功");
		}
		else{
			System.out.println("添加失败，输入的信息有误，或者用户的学号重复");
		}
		
	}

	/**
	 * 删除一个学生
	 */
	public static void del() {
		System.out.println("请输入用户的账户：");
		String username = Tools.scanner.next();
		Student student = StudentManager.findByUserName(username);
		if (student == null) {
			System.out.println("删除的用户不存在");
		} else {
			StudentManager.del(username);
			System.out.println("删除成功");
		}
	}
	
	/**
	 * 查找一个用户
	 */
	public static void findByUsername(){
		System.out.println("请输入用户的学号：");
		String username=Tools.scanner.next();
		Student student= StudentManager.findByUserName(username);
		if(student==null){
			System.out.println("你输入的学号找不到");
		}
		else{
			System.out.println(student);
		}
	}
	
	
	
	/**
	 * 查找所有的用户
	 */
	public static void find(){
		List<Student> list= StudentManager.find();
		for (Student student : list) {
			System.out.println(student);
		}
	}
		/**
	 * 用户修改自己的密码
	 */
	public static void updatePwd() {
		Student student = StudentManager.findByUserName(((Student)DataBase.getRequest().get("login")).getUsername());
		if (student == null) {
			System.out.println("要修改的用户不存在");
		} else {

			System.out.println("用户的密码是：*****" );
			System.out.println("修改请选择1，不修改请选择2");
			if (Tools.getInteger(Tools.scanner.next(), 2) == 1) {
				System.out.println("请输入用户的密码：");
				student.setPassword(Tools.scanner.next());
			}
			System.out.println("修改成功");
		}
	}
	/**
	 * 修改用户的信息,这是所有的信息
	 */
	public static void update() {
		System.out.println("请输入用户的账户：");
		String username = Tools.scanner.next();
		Student student = StudentManager.findByUserName(username);
		if (student == null) {
			System.out.println("要修改的用户不存在");
		} else {
			System.out.println("用户的姓名是：" + student.getName());
			System.out.println("修改请选择1，不修改请选择2");
			if (Tools.getInteger(Tools.scanner.next(), 2) == 1) {
				System.out.println("请输入用户的姓名：");
				student.setName(Tools.scanner.next());
			}

			System.out.println("用户的密码是：*****" );
			System.out.println("修改请选择1，不修改请选择2");
			if (Tools.getInteger(Tools.scanner.next(), 2) == 1) {
				System.out.println("请输入用户的密码：");
				student.setPassword(Tools.scanner.next());
			}

			System.out.println("用户的性别是：" + Tools.getSex(student.getSex()));
			System.out.println("修改请选择1，不修改请选择2");
			if (Tools.getInteger(Tools.scanner.next(), 2) == 1) {
				System.out.println("请选择用户的性别：");
				System.out.println("0：女；  1：男；  2：不详");

				// 输入用户的性别，并进行数据的校验
				int sex = Math.abs(Tools.getInteger(Tools.scanner.next(), 2));
				student.setSex(sex > 2 ? 2 : sex);
			}

			System.out.println("用户的年龄是：" + student.getAge());
			System.out.println("修改请选择1，不修改请选择2");
			if (Tools.getInteger(Tools.scanner.next(), 2) == 1) {
				System.out.println("请输入用户的年龄：");
				student.setAge(Tools.getInteger(Tools.scanner.next(), 0));
			}

			System.out.println("用户的地址是：" + student.getAddress());
			System.out.println("修改请选择1，不修改请选择2");
			if (Tools.getInteger(Tools.scanner.next(), 2) == 1) {
				System.out.println("请输入用户的地址：");
				student.setAddress(Tools.scanner.next());
			}
			System.out.println("修改成功");
		}
	}
}


