package 学生信息管理系统;

import data.DataBase;
import pojo.Student;
import tools.Stulint;
import tools.Stulint;
import tools.Tools;
import view.CourseView;
import view.ManagerPersonView;
import view.GradeView;
import view.StudentView;

/**
 * 这是程序启动的入口
 *https://blog.csdn.net/m0_46495243/article/details/115277921?utm_source=app
 */
public class Main {

	public static void main(String[] args) {
		//启动初始化
		Stulint.start();
		boolean system=true;
		while (system) {
			System.out.println("欢迎使用学生管理系统");
			System.out.println("-------------------------------------");
			System.out.println("请选择登录的用户的类型：");
			System.out.println("0：管理员；1：学生；2：退出");
			int userType = Tools.getInteger(Tools.scanner.next(), 1);
			if (userType == 1) {
				System.out.println("欢迎同学使用本系统");
				System.out.println("-------------------------------------");
				if (StudentView.login()) {
					boolean flag = true;
					while (flag) {
						System.out.println("请选择你的操作：");
						System.out.println("-------------------------------------");
						System.out.println("1:查看自己的信息");
						System.out.println("2:查看自己的成绩");
						System.out.println("4:修改自己的密码");
						System.out.println("3:退出登录");
						int type = Tools.getInteger(Tools.scanner.next(), 0);
						
						switch (type) {
						case 1:
							System.out.println(DataBase.getRequest().get("login"));
							break;
						case 2:
							GradeView.find(((Student) DataBase.getRequest().get("login")).getUsername());
							break;
						case 3:
							flag = false;
							break;
						case 4:
							StudentView.updatePwd();
							break;

						default:
							break;
						}
						

					}
				} else {
					System.out.println("用户登录失败");
					System.out.println("-------------------------------------");

				}
			} else if(userType==0){
				System.out.println("欢迎管理员使用本系统");
				System.out.println("-------------------------------------");
				if (ManagerPersonView.login()) {
					boolean flag = true;
					while (flag) {
						System.out.println("请选择你的操作：");
						System.out.println("-------------------------------------");
						System.out.println("2:查看所有用户的信息");
						System.out.println("3:查看所有用户的成绩");
						System.out.println("4:查看指定用户的成绩");
						System.out.println("5:查看指定用户的信息");
						System.out.println("6:添加课程");
						System.out.println("7:添加用户");
						System.out.println("8:添加成绩");
						System.out.println("9:修改用户");
						System.out.println("10:修改成绩");
						System.out.println("11:修改课程");
						System.out.println("12:显示课程");
						System.out.println("20:删除学生");
						System.out.println("13:退出登录");
						System.out.println("**********************");
						System.out.println("1:查看本人的信息");
						System.out.println("14:修改本人信息");
						System.out.println("15:修改其他管理员信息(超级管理员权限)");
						System.out.println("16:添加一个新的管理员(超级管理员权限)");
						System.out.println("17:删除一个管理员(超级管理员权限)");
						System.out.println("18:查询所有的管理员的信息(超级管理员权限)");
						System.out.println("19:查询指定的管理员的信息(超级管理员权限)");
						System.out.println("-------------------------------------");
						int type = Tools.getInteger(Tools.scanner.next(), 0);
						switch (type) {
						case 1:
							System.out.println(DataBase.getRequest().get("login"));
							break;
						case 2:
							StudentView.find();
							break;
						case 3:
							GradeView.findAll();
							break;
						case 4:
							StudentView.find();
							GradeView.find();
							break;
						case 5:
							StudentView.findByUsername();
							break;
						case 6:
							CourseView.add();
							break;
						case 7:
							StudentView.add();
							break;
						case 8:
							StudentView.find();
							CourseView.find();
							GradeView.add();
							break;
						case 9:
							StudentView.find();
							StudentView.update();
							break;
						case 10:
							StudentView.find();
							CourseView.find();
							GradeView.update();
							break;
						case 11:
							CourseView.find();
							CourseView.update();
							break;
						case 12:
							CourseView.find();
							break;
						case 13:
							flag = false;
							break;
						case 14:
							ManagerPersonView.updateMy();
							break;
						case 15:
							ManagerPersonView.find();
							ManagerPersonView.update();
							break;
						case 16:
							ManagerPersonView.add();
							break;
						case 17:
							ManagerPersonView.find();
							ManagerPersonView.del();
							break;
						case 18:
							ManagerPersonView.find();
							break;
						case 19:
							ManagerPersonView.findByUsername();
							break;
						case 20:
							StudentView.find();
							StudentView.del();
							break;

						default:
							break;
						}
					}

				}
			}
			else{
				//结束保存
				Stulint.stop();
				system=false;
			}
		}
	}

}

