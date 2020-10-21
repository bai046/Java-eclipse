package 栈;

import java.util.Stack;

public class Stackapp
{  public static void main(String[] args)
   {  Stack<String> st=new Stack<String>();  //建立String栈对象st
      st.push("a");			    //进栈顺序: a,b,c,d,e
      st.push("b"); st.push("c");
      st.push("d"); st.push("e");
      System.out.println("empty():" + st.empty());
					//输出:flase
      System.out.println("peek():" + st.peek());
					//输出:e
      System.out.println("search(Object o):" + st.search("a")); 	
					//输出:5
      System.out.println("search(Object o):" + st.search("e"));	
					//输出:1
      System.out.println("search(Object o):" + st.search("no"));
					//输出:-1
      while( !st.isEmpty())		//出栈顺序: e,d,c,b,a
           System.out.println(st.pop() + " ");
      System.out.println("empty():" + st.empty());		
					//输出:true
   }
}

//Stack容器主要的成员函数如下：
//boolean empty()：判断栈是否为空。
//int size()：返回栈中元素个数。
//E push(E item)：把对象压入栈顶，即进栈操作。
//E pop()：移除栈顶对象，并作为此函数的值返回该对象，即出栈操作。
//E peek()：查看栈顶对象，但不从栈中移除它，即返回栈顶元素操作。
//int search(Object o)：返回元素o在栈中的位置，该位置从栈顶开始往下算，栈顶为1。
//boolean contains(Object o)：如果栈中包含指定的元素o，则返回true；否则返回false。

//Java中的栈容器Stack<E>
//Java中提供了Stack栈容器。
//Stack容器只有一个出口即栈顶，可以在栈顶插入（进栈）和删除（出栈）元素。
//Stack容器不允许顺序遍历。
//由于stack采用泛型（类模板）设计，更高效和通用，在编程中尽量使用Stack！