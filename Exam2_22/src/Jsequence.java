class Joseph			//求解约瑟夫问题类
	{  int n,m;
	   Child first;			//首结点指针
	   public Joseph(int n1,int m1) 	//构造方法,建立有n1个结点的循环单链表
	   {  Child p,t;			//t指向新建循环单链表的尾结点
	      n=n1; m=m1;		//置数据成员值
	      first=new Child(1);	//先建立no为1的首结点
	      t=first;
	      for (int i=2;i<=n;i++)
	      {  p=new Child(i);		//建立一个编号为i的新结点p
	         t.next=p; t=p;		//将p结点链到末尾
	      }
	      t.next=first;		//构成一个首结点为first的循环单链表
	   }

public String Jsequence()	//求解约瑟夫序列
   {  String ans="";
      int i,j;
      Child p,q;
      for (i=1;i<=n;i++)		//共出列n个小孩
      {  p=first;
         j=1;
         while (j<m-1)		//从first结点开始报数，报到第m-1个结点
         {  j++;			//报数递增
            p=p.next;		//移到下一个结点
         }
         q=p.next;		//q指向第m个结点
         ans+=q.no+" ";		//该结点的小孩出列
         p.next=q.next;		//删除q结点
         first=p.next;		//从下一个结点重新开始
      }
      return ans;
   }
}