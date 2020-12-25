package 实训作业;

import java.util.ArrayList;
import java.util.Stack;

public class PolandNation {
	public static void main(String[] args) {
		String exp="3+4/25*8-6";
		ArrayList<String > list = toSuffixExpress(exp);
		System.out.println("输出转换结果：（郭淑瑛）\n"+list);
	}
	
	public static ArrayList<String> toSuffixExpress(String s){
		Stack<String> s1 = new Stack<>();
		ArrayList<String> s2= new ArrayList<>();
		char c;						//用来保存从表达式取出的每个字符
		boolean lastIsNumber =false;		//保存表达式上一个字符是否为数字
		for(int i=0;i<s.length();i++){
			c=s.charAt(i);
			if(c>='0' && c<='9'){	//如果是数
				if(lastIsNumber==true){
					String mergeStr=s2.get(s2.size()-1)+c;	//如果上一个是数字，将上一个数与当前字符拼接
					s2.set(s2.size()-1, mergeStr);			//将拼完的字符放入s2的顶端
				}else{
					s2.add(c+"");
				}
				lastIsNumber=true;}
			else if(isOPer(c)){//如果是运算符
				if(s1.isEmpty() || s1.peek().equals("(")){
					s1.push(c+"");
				}else {
					while(!s1.isEmpty() && !s1.peek().equals("(") 
							&& operLevel(c+"")<= operLevel(s1.peek())){
							s2.add(s1.pop());
					}
					s1.push(c+"");
				}
				lastIsNumber=false;
			}else if(c=='('){
				s1.push(c+"");
				lastIsNumber=false;
			}else if(c==')'){
				while(!s1.isEmpty() && !s1.peek().equals("(")){
					s2.add(s1.pop());
				}
				if(s1.peek().equals("(")){//如果栈顶为后括号，将后括号丢弃
					s1.pop();
				}
				lastIsNumber=false;		
			}
			
			
		}
		//将剩余的运算符压入s2
		while(!s1.isEmpty()){
			s2.add(s1.pop());
		}
		
		return s2;
		
	}
	//判断是否为运算符
	public static boolean isOPer(char oper){
		if(oper=='+' ||oper=='-' ||oper=='*' ||oper=='/'){
			return true;
		}
		else
			return false;
	}
	//返回运算符优先级
	public static int operLevel(String oper){
		if(oper.equals("+") ||oper.equals("-")){
			return 0;
		}
		else if(oper.equals("*") ||oper.equals("/")){
			return 1;
		}else{
			throw new RuntimeException("符号异常");
		}
		
	}

}
