package reserve;

public class 遍历可变参数 {
	
	public static int max(int...varArgs) {//可变长参数语法（...）
		if(varArgs.length<1)return 0;
		int result=varArgs[0];
		for(int n=1;n<varArgs.length;n++) {
			if(varArgs[n]>result)result=varArgs[n];
		}
		
//		for(int e:varArgs) {
//			if(e>result)result=e;
//		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(max(2,1));
		System.out.println(max(2,1,4));
		System.out.println(max(2,1,8,3));
		System.out.println(max(2));
		System.out.println(max());
	}

}
