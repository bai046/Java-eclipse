package 实训作业;

import java.util.ArrayList;
import java.util.Stack;

public class PolandNation01 {
	public static void main(String[] args) {
		String exp="300+51*(2+6)-109";
		//1.将中缀表达式转换成后缀表达式
		ArrayList<String > list = toSuffixExpress(exp);
		System.out.println("300+51*(2+6)-109 转换成后缀表达式:\n"+list);
		//2.将后缀表达式求值
		int r= calculate(list);
		System.out.println("后缀表达式计算结果："+r);
	}
	//2.将后缀表达式求值
	public static int calculate (ArrayList<String > list){
		Stack<String> s = new Stack<>();
		for(String item:list){
			if(item.matches("\\d+")){//判断item是否为数字格式
				s.push(item);
			}else{
				int x2 = Integer.parseInt(s.pop()) ;
				int x1 = Integer.parseInt(s.pop()) ;
				int res;
				switch(item){
				case "+": res=x1+x2;break;
				case "-": res=x1-x2;break;
				case "*": res=x1*x2;break;
				case "/": res=x1/x2;break;
				default:
					throw new RuntimeException("运算符错误~~");
				}
				s.push(res+"");
			}
		}
		return Integer.parseInt( s.pop());
	}
	
	//1.将中缀表达式转换成后缀表达式
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
				lastIsNumber=true;
			}else if(isOPer(c)){//如果是运算符
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
			return 1;
		}
		else if(oper.equals("*") ||oper.equals("/")){
			return 2;
		}else{
			throw new RuntimeException("符号异常");
		}
		
	}

}

