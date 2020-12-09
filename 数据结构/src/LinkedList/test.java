package LinkedList;
//验证类
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub自动生成的方法存根
		
		Student stu1=new Student(1,"张一");//具体数据
		Student stu2=new Student(2,"张二");
		Student stu3=new Student(3,"张三");
		Student stu4=new Student(4,"张四");
		StuNode sn1=new StuNode(stu1);//变为节点
		StuNode sn2=new StuNode(stu2);
		StuNode sn3=new StuNode(stu3);
		StuNode sn4=new StuNode(stu4);
//		定义一个空链表
		StuNode sn0=new StuNode(null);
		StuLinkList sl=new StuLinkList(sn0);//头为空
//		连起来
//		sl.addAtHead(sn1);
//		sl.addAtHead(sn2);
//		sl.addAtHead(sn3);
		sl.addAtEnd(sn1);
		sl.addAtEnd(sn2);
		sl.addAtEnd(sn3);
		
		sl.insertbefor(sn2,sn4);
		
		sl.delete(sn1);
		
		sl.showDatas();
		
	}

}
