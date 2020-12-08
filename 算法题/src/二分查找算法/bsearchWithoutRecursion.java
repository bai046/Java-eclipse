package 二分查找算法;
//算法的非递归实现:
public class bsearchWithoutRecursion {

	    public static int binarySearch(int []a,int num){
	        int len=a.length;
	        int high=len-1;
	        int low=0;
	        while(low<=high){
	            int mid=(high+low)>>1;
	            if(a[mid]==num)
	                return mid;
	            else if(a[mid]<num)
	                low=mid+1;
	            else
	                high=mid-1;
	        }
	        return -1;
	    }

	    public static void main(String args[]){
	        int []a={1,10,30,34,40,45,59};
	        int index=bsearchWithoutRecursion.binarySearch(a, 30);
	        System.out.println(index);
	    }
	
}
