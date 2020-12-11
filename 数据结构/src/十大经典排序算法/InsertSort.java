package 十大经典排序算法;

//插入排序
public class InsertSort {
    public static int[] insertSort(int[] arr) {
        if(arr == null || arr.length < 2)
            return arr;

        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int k = i - 1;
            while(k >= 0 && arr[k] > temp)
                k--;
            //腾出位置插进去,要插的位置是 k + 1;
            for(int j = i ; j > k + 1; j--)
                arr[j] = arr[j-1];
            //插进去
            arr[k+1] = temp;
        }
        return arr;
    }
}