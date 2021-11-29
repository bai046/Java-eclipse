package test.point;

public class Caller {

	public static void main(String[] args) {
		Point p = new /**Ê¡µôÁËclass XXX implements **/ Point() {
			@Override
			public String sayHello() {
				return "hello word";
			}
		};
		
		System.out.println(p.sayHello());
		
		p = () -> {
			return "hello word";
		};
		System.out.println(p.sayHello());
		
		p = Hello::speakHello;
		System.out.println(p.sayHello());
	}

}
