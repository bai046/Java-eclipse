package 二叉树类设计;

//对应Java语言的二叉链结点类BTNode<E>
class BTNode<E>			//二叉链中结点类
{  E data;			//存放数据元素
   BTNode lchild;		//指向左孩子结点
   BTNode rchild;		//指向右孩子结点
   public BTNode()		//默认构造方法
   {  lchild=rchild=null;  }
   public BTNode(E d)		//重载构造方法
   {  data=d;
      lchild=rchild=null;
   }
}

