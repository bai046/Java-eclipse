package 二叉树类设计;

import java.util.Stack;

public class BTreeClass		//二叉树类
{  BTNode<Character> b;		//根结点
   String bstr;			//二叉树的括号表示串
   public BTreeClass()		//构造方法
   {   b=null;  }
   //二叉树基本运算算法

   
//   由括号表示层str创建以b为根结点的二叉链存储结构
public void CreateBTree(String str)
{  Stack<BTNode> st=new Stack<BTNode>();	 //建立一个栈st
   BTNode<Character> p=null;
   boolean flag=true;
   char ch;
   int i=0;
   while (i<str.length())	//循环扫描str中每个字符
   {  ch=str.charAt(i);
      switch(ch)
      {
	case '(':
	   st.push(p);		//刚刚新建的结点有孩子,将其进栈
           flag=true;
           break;
	case ')':
           st.pop();		//栈顶结点的子树处理完，出栈
           break;
	case ',':
           flag=false;		//开始处理栈顶结点的右孩子
           break;
    default:
        p=new BTNode<Character>(ch);	//用ch值新建一个结点
        if (b==null) b=p;		//若尚未建立根结点,p作为根结点
        else				//已建立二叉树根结点
        {  if (flag)			//新结点p作为栈顶结点的左孩子
           {  if (!st.empty())
                 st.peek().lchild=p;
           }
           else			//新结点p作为栈顶结点的右孩子
           {  if (!st.empty())
                 st.peek().rchild=p;
           }
        }
        break;
     }
     i++;				//继续遍历
 }
}
}
