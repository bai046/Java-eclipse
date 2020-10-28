package reserve;

import java.util.Arrays;

public class 二维数组 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int iArray[][];
//		iArray=new int[2][3];
		int[][] i=new int[2][3];
		
		int j[][]=new int[2][3];
//		int jArray[][]=new int[2][]; 
//		jArray[0]=new int[3];   
//		jArray[1]=new int[5];
		
		//第一种方式：
	    int a[][]={{1,2,3},{4,5,6}};
	    System.out.println("a:"+Arrays.toString(a));
	    
	    int b[][]={{1,2,3},{4,5,6}};
	    System.out.println("b:"+Arrays.deepToString(b));
	    
	    //第二种方式；
	    //int[][] ints = new int[4][2];        
	    //ints[i][j] =__; //分别赋值
	    
	    //第三种方式：第二维的长度可以动态申请
//	    int[][] arr3 = new int[5][];       //五行的长度
//	    for(int i=0; i<arr3.length; ++i){      	
//	        arr3[i]=new int[i+1];         //列的长度每次都变化。每次都要重新申请空间(长度)
//	        for(int j=0; j<arr3[i].length; ++j){
//	            arr3[i][j]= i+j;  
//	            System.out.println( "arr3[i][j]:"+ arr3[i][j]);
//	        }
//	        
//	        System.out.println( "arr3[i][j]:"+ Arrays.toString(arr3[i]) );
//	    }
//	
//	 }
//		
		
	}
}


