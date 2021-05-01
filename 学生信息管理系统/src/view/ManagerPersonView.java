package view;

import java.util.Date;
import java.util.List;

import data.DataBase;
import pojo.ManagerPerson;
import manager.ManagerPersonManager;
import tools.Tools;

/**
 * 管理员的交互界面
 */
public class ManagerPersonView {

	/**
	 * 管理员登录
*/
	public static boolean login() {
		System.out.println("请输入管理员的账户：");
		String username = Tools.scanner.next();
		System.out.println("请输入管理员的密码：");
		String password = Tools.scanner.next();
		// 判断是否登录成功，如果成功将登录管理员的信息存放到request login中
		if (ManagerPersonManager.login(username, password)) {
			if (((ManagerPerson) DataBase.getRequest().get("login")).getRank() == 0) {
				System.out.println("欢迎超级管理员");
			} else {
				System.out.println("欢迎管理员");
			}
			return true;
		} else {
			System.out.println("登录失败");
			return false;
		}
	}

	/**
	 * 增加一个管理员
	 */
	public static void add() {
		if (((ManagerPerson) DataBase.getRequest().get("login")).getRank() == 0) {
			// 新建一个学生的对象
			ManagerPerson managerPerson = new ManagerPerson();
			// 添加创建管理员的时间
			managerPerson.setCreateDate(new Date());
			managerPerson.setRank(1);
			System.out.println("请输入管理员的账户：");
			managerPerson.setUsername(Tools.scanner.next());
			System.out.println("请输入管理员的密码：");
			managerPerson.setPassword(Tools.scanner.next());
			System.out.println("请输入管理员的姓名：");
			managerPerson.setName(Tools.scanner.next());
			System.out.println("请选择管理员的性别：");
			System.out.println("0：女；  1：男；  2：不详");

			// 输入管理员的性别，并进行数据的校验
			int sex = Math.abs(Tools.getInteger(Tools.scanner.next(), 2));
			managerPerson.setSex(sex > 2 ? 2 : sex);

			System.out.println("请输入管理员年龄：");
			managerPerson.setAge(Tools.getInteger(Tools.scanner.next(), 0));
			managerPerson.setCreateDate(new Date());// 添加管理员的时间
			System.out.println("请输入管理员的地址：");
			managerPerson.setAddress(Tools.scanner.next());

			if(ManagerPersonManager.add(managerPerson)){
				System.out.println("添加成功");
			}
			else{
				System.out.println("添加失败，用户可能已经存在");
			}
			
		}
		else{
			System.out.println("您的权限不足");
		}
	}

	/**
	 * 删除一个管理员
	 */
	public static void del() {
		if (((ManagerPerson) DataBase.getRequest().get("login")).getRank() == 0) {
			System.out.println("请输入管理员的账户：");
			String username = Tools.scanner.next();
			ManagerPerson managerPerson = ManagerPersonManager.findByUserName(username);
			if (managerPerson == null) {
				System.out.println("删除的管理员不存在");
			} else {
				if(managerPerson.getRank()==1){
					ManagerPersonManager.del(username);
					System.out.println("删除成功");
				}
				else{
					System.out.println("删除失败，您的权限不足");
				}
				
			}
		} else {
			System.out.println("您的权限不足");
		}
	}

	/**
	 * 查找一个管理员
	 */
	public static void findByUsername() {
		if (((ManagerPerson) DataBase.getRequest().get("login")).getRank() == 0) {
			System.out.println("请输入管理员的编号：");
			String username = Tools.scanner.next();
			ManagerPerson managerPerson = ManagerPersonManager.findByUserName(username);
			if (managerPerson == null) {
				System.out.println("你输入的编号找不到");
			} else {
				System.out.println(managerPerson);
			}
		} else {
			System.out.println("您的权限不足");
		}
	}

	/**
	 * 查找所有的管理员
	 */
	public static void find() {
		if (((ManagerPerson) DataBase.getRequest().get("login")).getRank() == 0) {

			List<ManagerPerson> list = ManagerPersonManager.find();
			for (ManagerPerson managerPerson : list) {
				System.out.println(managerPerson);
			}
		} else {
			System.out.println("您的权限不足");
		}
	}

	/**
	 * 修改本人的信息
	 */
	public static void updateMy() {

		ManagerPerson managerPerson = ((ManagerPerson) DataBase.getRequest().get("login"));
		if (managerPerson == null) {
			System.out.println("要修改的管理员不存在");
		} else {
			System.out.println("管理员的姓名是：" + managerPerson.getName());
			System.out.println("修改请选择1，不修改请选择2");
			if (Tools.getInteger(Tools.scanner.next(), 2) == 1) {
				System.out.println("请输入管理员的姓名：");
				managerPerson.setName(Tools.scanner.next());
			}

			System.out.println("管理员的密码是：*****");
			System.out.println("修改请选择1，不修改请选择2");
			if (Tools.getInteger(Tools.scanner.next(), 2) == 1) {
				System.out.println("请输入管理员的密码：");
				managerPerson.setPassword(Tools.scanner.next());
			}

			System.out.println("管理员的性别是：" + Tools.getSex(managerPerson.getSex()));
			System.out.println("修改请选择1，不修改请选择2");
			if (Tools.getInteger(Tools.scanner.next(), 2) == 1) {
				System.out.println("请选择管理员的性别：");
				System.out.println("0：女；  1：男；  2：不详");

				// 输入管理员的性别，并进行数据的校验
				int sex = Math.abs(Tools.getInteger(Tools.scanner.next(), 2));
				managerPerson.setSex(sex > 2 ? 2 : sex);
			}

			System.out.println("管理员的年龄是：" + managerPerson.getAge());
			System.out.println("修改请选择1，不修改请选择2");
			if (Tools.getInteger(Tools.scanner.next(), 2) == 1) {
				System.out.println("请输入管理员的年龄：");
				managerPerson.setAge(Tools.getInteger(Tools.scanner.next(), 0));
			}

			System.out.println("管理员的地址是：" + managerPerson.getAddress());
			System.out.println("修改请选择1，不修改请选择2");
			if (Tools.getInteger(Tools.scanner.next(), 2) == 1) {
				System.out.println("请输入管理员的地址：");
				managerPerson.setAddress(Tools.scanner.next());
			}
			
			System.out.println("修改成功");
		}
	}

	/**
	 * 修改管理员的信息
	 */
	public static void update() {
		if (((ManagerPerson) DataBase.getRequest().get("login")).getRank() == 0) {

			System.out.println("请输入管理员的账户：");
			String username = Tools.scanner.next();
			ManagerPerson managerPerson = ManagerPersonManager.findByUserName(username);
			if (managerPerson == null) {
				System.out.println("要修改的管理员不存在");
			} else {
				System.out.println("管理员的姓名是：" + managerPerson.getName());
				System.out.println("修改请选择1，不修改请选择2");
				if (Tools.getInteger(Tools.scanner.next(), 2) == 1) {
					System.out.println("请输入管理员的姓名：");
					managerPerson.setName(Tools.scanner.next());
				}

				System.out.println("管理员的密码是：*****");
				System.out.println("修改请选择1，不修改请选择2");
				if (Tools.getInteger(Tools.scanner.next(), 2) == 1) {
					System.out.println("请输入管理员的密码：");
					managerPerson.setPassword(Tools.scanner.next());
				}

				System.out.println("管理员的性别是：" + Tools.getSex(managerPerson.getSex()));
				System.out.println("修改请选择1，不修改请选择2");
				if (Tools.getInteger(Tools.scanner.next(), 2) == 1) {
					System.out.println("请选择管理员的性别：");
					System.out.println("0：女；  1：男；  2：不详");

					// 输入管理员的性别，并进行数据的校验
					int sex = Math.abs(Tools.getInteger(Tools.scanner.next(), 2));
					managerPerson.setSex(sex > 2 ? 2 : sex);
				}

				System.out.println("管理员的年龄是：" + managerPerson.getAge());
				System.out.println("修改请选择1，不修改请选择2");
				if (Tools.getInteger(Tools.scanner.next(), 2) == 1) {
					System.out.println("请输入管理员的年龄：");
					managerPerson.setAge(Tools.getInteger(Tools.scanner.next(), 0));
				}

				System.out.println("管理员的地址是：" + managerPerson.getAddress());
				System.out.println("修改请选择1，不修改请选择2");
				if (Tools.getInteger(Tools.scanner.next(), 2) == 1) {
					System.out.println("请输入管理员的地址：");
					managerPerson.setAddress(Tools.scanner.next());
				}
				System.out.println("修改成功");
			}
		} else {
			System.out.println("您的权限不足");
		}
	}
}

