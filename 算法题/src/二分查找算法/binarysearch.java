package 二分查找算法;
//算法的递归实现:
public class binarysearch {
	    public static int binarySearch_(int []a,int low, int high,int num){
	        if(low<=high){
	            int mid=(low+high)>>1;
	            if(a[mid]==num)
	                return mid;
	            else if(a[mid]<num)
	                low=mid+1;
	            else
	                high=mid-1;
	            return binarySearch_(a,low,high,num);
	        }else
	            return -1;
	    }

	    public static void main(String args[]){
	        int []a={1,10,30,34,40,45,59};
	        int index=binarysearch.binarySearch_(a, 0,a.length-1,3);
	        System.out.println(index);
	    }
}
