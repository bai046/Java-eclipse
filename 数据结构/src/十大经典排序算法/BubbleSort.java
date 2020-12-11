package 十大经典排序算法;
//冒泡排序
public class BubbleSort {
    public static int[] bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n -i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    int t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                }
            }
        }
        return arr;
    }
}

//优化
//public class BubbleSort {
//    public static int[] bubbleSort(int[] arr) {
//        if (arr == null || arr.length < 2) {
//            return arr;
//        }
//        int n = arr.length;
//        for (int i = 0; i < n; i++) {
//            boolean flag = true;
//            for (int j = 0; j < n -i - 1; j++) {
//                if (arr[j + 1] < arr[j]) {
//                    flag = false;
//                    int t = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = t;
//                }
//            }
//            //一趟下来是否发生位置交换
//            if(flag)
//                break;
//        }
//        return arr;
//    }
//}
