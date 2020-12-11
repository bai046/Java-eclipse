package  Æ¥Ûæ≠µ‰≈≈–ÚÀ„∑®;

import java.util.Arrays;

public class ≈≈–Útext {

//	https://www.cnblogs.com/itsharehome/p/11058010.html ‘¥¥˙¬Î	
	
	public static void main(String[] args) {
        int a[] = {1,89,67,988,7,54,88,2,45,67,89,65,89};
        System.out.printf("≈≈–Ú«∞:");
        System.out.printf(Arrays.toString(a)+"\n");
        
        Heap.heapSort(a, a.length);
        System.out.printf("∂—≈≈–Ú:");
        System.out.printf(Arrays.toString(a)+"\n");
        BucketSort.BucketSort(a);
        System.out.printf("Õ∞≈≈–Ú:");
        System.out.printf(Arrays.toString(a)+"\n");
        SelectSort.selectSort(a);
        System.out.printf("—°‘Ò≈≈–Ú:");
        System.out.printf(Arrays.toString(a)+"\n");
        BubbleSort.bubbleSort(a);
        System.out.printf("√∞≈›≈≈–Ú:");
        System.out.printf(Arrays.toString(a)+"\n");
        Counting.countSort(a);
        System.out.printf("º∆ ˝≈≈–Ú:");
        System.out.printf(Arrays.toString(a)+"\n");
        InsertSort.insertSort(a);
        System.out.printf("≤Â»Î≈≈–Ú:");
        System.out.printf(Arrays.toString(a)+"\n");
        MergeSort.mergeSort(a);
        System.out.printf("πÈ≤¢≈≈–Ú:");
        System.out.printf(Arrays.toString(a)+"\n");
        QuickSort.quickSort(a,1,12);
        System.out.printf("øÏÀŸ≈≈–Ú:");
        System.out.printf(Arrays.toString(a)+"\n");
        RadioSort.radioSort(a);
        System.out.printf("ª˘ ˝≈≈–Ú:");
        System.out.printf(Arrays.toString(a)+"\n");
        ShellSort.shellSort(a);
        System.out.printf("œ£∂˚≈≈–Ú:");
        System.out.printf(Arrays.toString(a)+"\n");
        
        
        
    }

}
