package manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import data.DataBase;
import pojo.ManagerPerson;

/**
 * 管理员的业务处理
 *
 */
public class ManagerPersonManager {


	// 添加
	public static boolean add(ManagerPerson ManagerPerson) {
		if(DataBase.getManagerPersons().containsKey(ManagerPerson.getUsername())){
			return false;
		}
		else{
			DataBase.getManagerPersons().put(ManagerPerson.getUsername(), ManagerPerson);
			return true;
		}	
		
	}

	// 删除
	public static void del(String username) {
		DataBase.getManagerPersons().remove(username);
	}

	// 改
	public static void update(ManagerPerson ManagerPerson) {
		DataBase.getManagerPersons().put(ManagerPerson.getUsername(), ManagerPerson);
	}

	// 查所有
	public static List<ManagerPerson> find() {
		Map<String, ManagerPerson> stus = DataBase.getManagerPersons();
		Set<String> kSet = stus.keySet();
		Object[] objs = kSet.toArray();
		List<ManagerPerson> list = new ArrayList<ManagerPerson>();
		for (int i = 0; i < objs.length; i++) {
			String sid = (String) (objs[i]);
			list.add(stus.get(sid));
		}
		return list;
	}

	// 查一个
	public static ManagerPerson findByUserName(String username) {
		return DataBase.getManagerPersons().get(username);
	}

	// 登录
	public static boolean login(String username, String password) {
		try {
			ManagerPerson stu = DataBase.getManagerPersons().get(username);
			if (password.equals(stu.getPassword())) {
				// 登录成功
				DataBase.getRequest().put("login", stu);
				return true;
			} else {
				// 登录失败
				return false;
			}
		} catch (Exception e) {
			return false;
		}

	}
}


