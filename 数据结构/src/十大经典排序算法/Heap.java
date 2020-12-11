package 十大经典排序算法;

import java.util.Arrays;

public class Heap {

    public static void swap(int[] num,int start, int end){
        // 初始位置 
        int s = start;
        //取的左右节点较大的点的位置
        int lOr = 2*s+1;
        //记录临时值 用于后面交换
        int tmp = num[s];
        
        //当点的值大于数组长度跳出，s作为记录上一个值，lOr作为下一个值，当满足条件后就做交换，这次的点就赋值为tmp
        for(;lOr <= end; s=lOr, lOr = lOr*2+1){
            if(lOr < end && num[lOr] < num[lOr+1]){
                lOr++;
            }
            if(tmp >= num[lOr]){
                break;
            }else {
                num[s] = num[lOr];
                num[lOr] = tmp;
            }
        }
    }


    public static void heapSort(int[] num, int len){
        int i, tmp;
        //先调树结构
        for(i = len/2-1; i >= 0; i--){
            swap(num,i,len-1);
        }
        for(i = len - 1; i > 0; i--){
            tmp = num[0];
            num[0] = num[i];
            num[i] = tmp;
            //排序好一个就调整一次树的结构
            swap(num,0,i-1);
        }

    }

    public static void main(String[] args) {
        int a[] = {20,2,80,1,16,100,6,78};
        System.out.printf("排序前:");
        System.out.printf(Arrays.toString(a)+"\n");
        
        Heap.heapSort(a, a.length);
        System.out.printf("排序后:");
        System.out.printf(Arrays.toString(a)+"\n");
        
        
//        System.out.printf("排序前:");
//        for (int i=0; i<a.length; i++)
//            System.out.print(a[i]+" ");
//        System.out.printf("\n");
//        heapSort(a, a.length);
//
//        System.out.printf("排序后:");
//        for (int i=0; i<a.length; i++)
//            System.out.print(a[i]+" ");
//        System.out.printf("\n");
    }
}

