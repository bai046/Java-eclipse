package linerList;

public class yz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//类是抽象的，需要实例化使用
		StuSeqList sl=new StuSeqList(14,10);
		
		Student stu1 =new Student(1,"张三");
		
		System.out.print(sl.insert(8, stu1));
		//System.out.print(sl.insert(10, stu1));
		//System.out.print(sl.insert(10, stu1));
		//System.out.print(sl.insert(10, stu1));
		//System.out.print(sl.insert(10, stu1));
		
	}

}