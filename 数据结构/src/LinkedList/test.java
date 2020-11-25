package LinkedList;
//验证类
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub自动生成的方法存根
		
		Student stu1=new Student(1,"张一");//三个数据
		Student stu2=new Student(1,"张二");
		Student stu3=new Student(1,"张三");
		StuNode sn1=new StuNode(stu1);//变为三个节点
		StuNode sn2=new StuNode(stu2);
		StuNode sn3=new StuNode(stu3);
		StuNode sn0=new StuNode(null);
		StuLinkList sl=new StuLinkList(sn0);//头为空
//		连起来
		sl.addAtHead(sn1);
		sl.addAtHead(sn2);
		sl.addAtHead(sn3);
		sl.showDatas();
		
	}

}
