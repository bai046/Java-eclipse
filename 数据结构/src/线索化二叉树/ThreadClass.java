package 线索化二叉树;

public class ThreadClass
{  ThNode b;		//二叉树的根结点
   ThNode root;		//线索二叉树的头结点
   ThNode pre;		//用于中序线索化,指向中序前驱结点
   String bstr;
   public ThreadClass()
   {
      root=null;
   }
   //中序线索二叉树的基本运算
public void CreateThread()	//建立以root为头结点的中序线索二叉树
{  root=new ThNode();		//创建头结点root
   root.ltag=0; root.rtag=1;	//头结点域置初值
   if (b==null)			//b为空树时
   {  root.lchild=root;
      root.rchild=null;
   }
   else				//b不为空树时
   {  root.lchild=b;
      pre=root;			//pre是p的前驱结点,用于线索化
      Thread(b);			//中序遍历线索化二叉树
      pre.rchild=root;		//最后处理,加入指向根结点的线索
      pre.rtag=1;
      root.rchild=pre;		//根结点右线索化
   }
}

private void Thread(ThNode p)	//对以p为根结点的二叉树进行中序线索化
{  if (p!=null)
   {
      Thread(p.lchild);		//左子树线索化
      if (p.lchild==null)	//前驱线索
      {  p.lchild=pre;		//给结点p添加前驱线索
         p.ltag=1;
      }
      else p.ltag=0;
      if (pre.rchild==null)
      {  pre.rchild=p;		//给结点pre添加后继线索
         pre.rtag=1;
      }
      else pre.rtag=0;
      pre=p;			//置p结点为下一次访问结点的前驱结点
      Thread(p.rchild);		//右子树线索化
   }
}
}
