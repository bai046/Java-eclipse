package 递归;

import java.util.ArrayList;
//【例5.6】采用递归算法求解迷宫问题，并输出从入口到出口的所有迷宫路径。 
public class Exam5_5
{  public static void main(String[] args)
   {  int [][] a= { {1,1,1,1,1,1},{1,0,1,0,0,1},
	  	   {1,0,0,0,1,1},{1,0,1,0,0,1},
		   {1,0,0,0,0,1},{1,1,1,1,1,1} };
   
   for(int i=0;i<a.length;i++) {//a.length表示行数
		System.out.print("{");
		for(int j=0;j<a[i].length;j++) {//a[i].length表示列数
			System.out.print(a[i][j]+" ");
		}
		System.out.print("}");
		System.out.println();
	}
   
      MazeClass mz=new MazeClass(6,6);
      ArrayList<Box> path=new ArrayList<Box>();
      mz.Setmg(a);
      mz.mgpath(1,1,4,4,path);
   }
}
