package reserve;

//private用get方法set方法调用
//Alt+Shift+s   按r=获取get，set方法

public class gese {
	
private String name;

//	构造函数：给属性初始化
	public gese() {
		this.name="xiaozhu";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Friend xiaofang=new Friend();
		xiaofang.age=18;
		System.out.print(xiaofang.age);
//		xiaofang.name=zhuzhu;
//		System.out.print(xiaofang.name);
//		通过set方法设置name属性值
		xiaofang.setName("zhuzhu");
//		通过get方法获取name属性值
		String name=xiaofang.getName();
		
		System.out.print(name);

		
	}
}
