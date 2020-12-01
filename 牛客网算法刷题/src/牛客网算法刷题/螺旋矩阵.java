package 牛客网算法刷题;
import java.util.*;
//给定一个m x n大小的矩阵（m行，n列），按螺旋的顺序返回矩阵中的所有元素。
//输入
//[[1,2,3],[4,5,6],[7,8,9]]
//返回值
//[1,2,3,6,9,8,7,4,5]
//1 2 3    螺旋 1 2 3 6 9 8 7 4 5
//4 5 6
//7 8 9 
public class 螺旋矩阵 {
	
public static ArrayList<Integer> spiralOrder(int[][] matrix) {
    ArrayList<Integer> res = new ArrayList<>();
    if(matrix.length == 0)
        return res;
    int top = 0, bottom = matrix.length-1;
    int left = 0, right = matrix[0].length-1;

    while( top < (matrix.length+1)/2 && left < (matrix[0].length+1)/2 ){
        //上面  左到右
        for(int i = left; i <= right; i++){
            res.add(matrix[top][i]);
        }

        //右边 上到下
        for(int i = top+1; i <= bottom; i++){
            res.add(matrix[i][right]);
        }

        //下面  右到左
        for(int i = right-1; top!=bottom && i>=left; i--){
            res.add(matrix[bottom][i]);
        }

        //左边 下到上
        for(int i = bottom-1; left!=right && i>=top+1; i--){
            res.add(matrix[i][left]);
        }
        ++top;
        --bottom;
        ++left;
        --right;
    }
    return res;
    
    
}

public static void main(String[] args) {
    //请在此测试你写的方法
    //测试
    test();
}
private static void test() {
	// TODO Auto-generated method stub
	 int[][] matrix = {{1, 2, 3},{4, 5, 6},{7, 8, 9},{1, 2, 3}};
	 ArrayList<Integer> result = spiralOrder(matrix);
     System.out.println("你的输入为："+Arrays.deepToString(matrix));
     System.out.print("你的输出为:");
     System.out.println(result);
     
     }

}

