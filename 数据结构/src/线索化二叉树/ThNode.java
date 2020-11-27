package 线索化二叉树;

class ThNode			//线索二叉树结点类型
{  char data;			//存放结点值
   ThNode lchild,rchild;		//左、右孩子或线索的指针
   int ltag,rtag;		//左、右标志
   public ThNode()		//默认构造方法
   {  lchild=rchild=null;
      ltag=rtag=0;
   }
   public ThNode(char d)		//重载构造方法
   {  data=d;
      lchild=rchild=null;
      ltag=rtag=0;
   }
}
