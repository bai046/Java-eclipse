package 哈希表;

import java.util.Scanner;
 
//哈希表(本质就是数组)的结构是由数组+链表或者数组+二叉树组成，实现的思路是创建一个固定大小的链表数组，
//将各条链表交给数组来进行管理，根据自定义的规则，将数据依次插入链表中，这样查找起来会非常方便。
//https://blog.csdn.net/weixin_44279178/article/details/108469778
public class HashTableDemo {
	public static void main(String[] args) {
		// 创建Hashtab
		HashTable ht = new HashTable(7);
		String key = "";
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("添加雇员：add");
			System.out.println("遍历雇员：list");
			System.out.println("查找雇员：get");
			System.out.println("删除雇员：del");
			System.out.println("退出：exit");
			key = sc.next();
			switch (key) {
			case "add":
				System.out.println("输入id");
				int id = sc.nextInt();
				System.out.println("输入姓名");
				String name = sc.next();
				Emp emp = new Emp(id, name);
				ht.add(emp);
				break;
			case "list":
				ht.list();
				break;
			case "exit":
				System.out.println("退出系统！");
				sc.close();
				System.exit(0);
			case "get":
				System.out.println("请输入id");
				int no = sc.nextInt();
				ht.findById(no);
				break;
			case "del":
				System.out.println("请输入要删除员工的Id");
				int eid = sc.nextInt();
				ht.del(eid);
				break;
			default:
				System.out.println("输入错误!");
				break;
			}
		}
	}
}
 
//创建hash表，管理多条链表
class HashTable {
	private EmpLinkedList[] arr;
	private int size;
 
	// 初始化构造器
	public HashTable(int size) {
		// 创建大小为7的数组
		arr = new EmpLinkedList[size];
		this.size = size;
		// 除了初始化数组，还需要初始化链表
		for (int i = 0; i < size; i++) {
			arr[i] = new EmpLinkedList();
		}
	}
 
	// 添加员工
	public void add(Emp emp) {
		// 根据散列函数确定员工编号应该放在哪条链表上面
		int hashFun = hashFun(emp.id);
		arr[hashFun].add(emp);
	}
 
	// 自定义散列函数
	public int hashFun(int id) {
		return id % size;
	}
 
	// 遍历哈希表
	public void list() {
		for (int i = 0; i < size; i++) {
			arr[i].list(i);
		}
	}
	//根据id删除员工
	public void del(int no) {
		int id = hashFun(no);
		arr[id].del(no);
	}
 
	// 根据Id查找雇员
	public void findById(int id) {
		int hashFun = hashFun(id);
		Emp emp = arr[hashFun].findById(id);
		if (emp == null) {
			System.out.println("没有该员工！");
		} else {
			System.out.printf("员工id：%d,姓名：%s", emp.id, emp.name);
		}
	}
}
 
//创建一个雇员
class Emp {
	public int id;
	public String name;
	public Emp next;
 
	public Emp(int id, String name) {
		this.id = id;
		this.name = name;
	}
 
}
 
//创建一个链表类，封装增删改查方法
class EmpLinkedList {
	// 创建一个头结点，直接指向第一个Emp
	private Emp head;// 默认为null
 
	// 根据雇员ID查找
	public Emp findById(int id) {
		// 当头结点为空时，说明链表为空！
		if (head == null) {
			return null;
		}
		Emp temp = head;
		while (true) {
			// 找到ID
			if (temp.id == id) {
				break;
			}
			// 链表遍历完毕没有找到
			if (temp.next == null) {
				temp = null;
				break;
			}
			temp = temp.next;
		}
		return temp;
	}
 
	/*
	 * 添加雇员
	 */
	public void add(Emp emp) {
		
		// 如果是添加的是第一个雇员，将头结点直接指向当前添加的节点
		if (head == null) {
			head = emp;
			return;
		}
 
		Emp temp = head;// 定义辅助节点
		// 不是第一个节点，遍历链表，将待添加的节点放在最后一个节点的后面
		// 循环遍历找到最后一个节点
		while (true) {
			if (temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		// 将添加的节点放在找到的最后节点的后面
		temp.next = emp;
	}
 
	// 遍历节点
	public void list(int no) {
		if (head == null) {
			System.out.println("第" + (no + 1) + "链表为空！");
			return;
		}
		Emp temp = head;// 定义辅助节点，用于遍历
		while (true) {
			System.out.printf("第" + (no + 1) + "链表的id是%d,姓名是%s\t", temp.id, temp.name);
			if (temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		System.out.println();
	}
 
	// 删除雇员
	public void del(int no) {
		if(head == null) {
			System.out.println("该链表为空！");
			return;
		}
		// 当头结点的id等于要查找的id，直接删除
		if (head.id == no) {
			head = head.next;
			return;
		}
		Emp temp = head;// 定义辅助节点
		boolean flag = false;
		while (true) {
 
			if (temp.next == null) {
				break;// 说明没有找到该点
			}
			if (temp.next.id == no) {
				// 删除操作
				flag = true;
				break;
			}
		}
		if (flag) {
			// 找到该id，删除
			temp.next = temp.next.next;
		} else {
			System.out.println("没有找到该员工！");
		}
	}
}