package 递归;

import java.util.ArrayList;

class MazeClass				//求解迷宫路径类
{  final int MaxSize=20;
   int [][] mg;				//迷宫数组
   int m,n;				//迷宫行列数
   int cnt=0;				//累计迷宫路径数
   public MazeClass(int m1,int n1)	//构造方法
   {  m=m1;
      n=n1;
      mg=new int[MaxSize][MaxSize];
   }
   public void Setmg(int [][] a)		//设置迷宫数组
   {  for (int i=0;i<m;i++)
         for (int j=0;j<n;j++)
             mg[i][j]=a[i][j];
   }
   
//   mgpath(int xi，int yi，int xe，int ye，Box path)：求从(xi，yi)到(xe，ye)的迷宫路径，用path变量保存迷宫路径。
   void mgpath(int xi,int yi,int xe,int ye,ArrayList<Box> path) 
   //求解迷宫路径为:(xi,yi)->(xe,ye)
  {  Box b;
     int di,i=0,j=0;
     b=new Box(xi,yi);
     path.add(b);				//将(xi,yi)添加到path中
     mg[xi][yi]=-1;			//mg[xi][yi]=-1		
     if (xi==xe && yi==ye)			//找到了出口,输出一个迷宫路径
     {  System.out.printf("迷宫路径%d:",++cnt);
        for (int k=0;k<path.size();k++)	 //输出path中的迷宫路径
           System.out.printf("  (%d,%d)",path.get(k).i,path.get(k).j);
        System.out.println();
        mg[xi][yi]=0;			//恢复为0,否则别的路径找不到出口
     }
     else					//(xi,yi)不是出口
     {  di=0;
     while (di<4)		     //处理(xi,yi)四周的相邻方块(i,j)
     {  switch(di)
        {
		case 0:i=xi-1; j=yi;   break;
		case 1:i=xi;   j=yi+1; break;
		case 2:i=xi+1; j=yi;   break;
		case 3:i=xi;   j=yi-1; break;
        }
        if (mg[i][j]==0)	     //(i,j)可走时
           mgpath(i,j,xe,ye,path); //从(i,j)出发查找迷宫路径
        di++;			     //继续处理(xi,yi)下一个相邻方块
     }
  }
  path.remove(path.size()-1);	     //删除path末尾方格（回退一个方块）
  mg[xi][yi]=0;
}
}

//求解迷宫问题的递归模型如下：
//gpath(xi,yi,xe,ye,path)  将(xi,yi)添加到path中;			                     	   		  
//置mg[xi][yi]=-1;
// 输出path中的迷宫路径;
// 恢复出口迷宫值为0即置mg[xe][ye]=0
//若(xi,yi)=(xe,ye)即找到出口
//mgpath(xi,yi,xe,ye,path)  将(xi,yi)添加到path中;			                      			  
//置mg[xi][yi]=-1;
// 对于(xi,yi)每个相邻可走方块(i,j)，
//调用mg(i,j,xe,ye,path);
// path回退一步并置mg[xi][yi]=0;
//若(xi,yi)不是出口
